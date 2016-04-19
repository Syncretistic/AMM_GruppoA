/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.tonino.servlets;

import amm.tonino.shop.Item;
import amm.tonino.shop.ItemFactory;
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
@WebServlet(name = "Cliente", urlPatterns = {"/cliente.html"})
public class Cliente extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        if(session != null){
            request.setAttribute("buyer", session.getAttribute("loggedBuyer"));
            ArrayList<Item> itemList = ItemFactory.getInstance().getItemList();
            if(session.getAttribute("loggedBuyer") != null){
                if(request.getParameter("itemId")!= null){
                    int itemId = Integer.parseInt(request.getParameter("itemId"));
                    Item item = ItemFactory.getInstance().getItemById(itemId);
                    request.setAttribute("itemDetails", item);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    System.out.println("match found");
                } else {
                    request.setAttribute("itemList", itemList);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("error_msg", true);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
        } else {
                request.setAttribute("error_msg", true);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
        }
        
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
