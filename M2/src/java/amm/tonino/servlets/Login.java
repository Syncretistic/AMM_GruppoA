package amm.tonino.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import amm.tonino.shop.Buyer;
import amm.tonino.shop.BuyerFactory;
import amm.tonino.shop.Vendor;
import amm.tonino.shop.VendorFactory;
import amm.tonino.shop.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Login", urlPatterns = {"/login.html"})
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        if (session.getAttribute("loggedUser") != null){
            if(request.getParameter("logout") != null){
                session.invalidate();
            } else {
                User user = (User)session.getAttribute("loggedUser");
                if(user instanceof Vendor){
                            session.setAttribute("loggedVendor", user);
                            response.sendRedirect("venditore.html");  
                            return;
                        } else {
                            session.setAttribute("loggedBuyer", user);
                            response.sendRedirect("cliente.html");  
                            return;
                        }
            }
        }
        if(request.getParameter("Submit") != null)
        {
            String username = request.getParameter("user");
            String password = request.getParameter("psw");
            
            ArrayList<Vendor> vendorList = VendorFactory.getInstance().getVendorList();
            ArrayList<Buyer> buyerList = BuyerFactory.getInstance().getBuyerList();
            ArrayList<User> userList = new ArrayList<User>();
            userList.addAll(vendorList);
            userList.addAll(buyerList);
            for(User u : userList){
                
                if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    session.setAttribute("loggedUser", u);
                    if(u instanceof Vendor){
                        session.setAttribute("loggedVendor", u);
                        response.sendRedirect("venditore.html");  
                        return;
                    } else {
                        session.setAttribute("loggedBuyer", u);
                        response.sendRedirect("cliente.html");  
                        return;
                    }                    
                }
            }
            request.setAttribute("login_failed", true);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
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