package amm.tonino.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import amm.tonino.classes.AccountFactory;
import amm.tonino.classes.Buyer;
import amm.tonino.classes.ItemFactory;
import amm.tonino.classes.Vendor;
import amm.tonino.classes.User;
import amm.tonino.classes.UserFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Saverio
 */
@WebServlet(name = "Login", urlPatterns = {"/login.html"}, loadOnStartup = 0)
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CLEAN_PATH = "../../web/WEB-INF/db/ammdb";
    private static final String DB_BUILD_PATH = "WEB-INF/db/ammdb";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        if (session.getAttribute("loggedVendor") != null){
            System.out.println("1");
            if(request.getParameter("logout") != null){
                session.invalidate();
                
            } else {
                response.sendRedirect("venditore.html");  
                return;
            }
        } else if (session.getAttribute("loggedBuyer") != null){
            if(request.getParameter("logout") != null){
                session.invalidate();
                
            } else {
                response.sendRedirect("cliente.html");  
                return;
            }
        }
            
     
        if(request.getParameter("Submit") != null)
        {
            String username = request.getParameter("user");
            String password = request.getParameter("psw");
            try {
                User user = UserFactory.getInstance().userLogin(username,password);
                if (user != null) {
                    if (user instanceof Vendor){
                        session.setAttribute("loggedVendor", user);
                        response.sendRedirect("venditore.html");  
                        return;
                    } else if (user instanceof Buyer){
                        session.setAttribute("loggedBuyer", user);
                        response.sendRedirect("cliente.html");  
                        return;
                    }                    
                }
            } catch(SQLException ex){
                ex.printStackTrace();
            } 
            request.setAttribute("login_failed", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        System.out.println("2");
        request.getRequestDispatcher("login.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}