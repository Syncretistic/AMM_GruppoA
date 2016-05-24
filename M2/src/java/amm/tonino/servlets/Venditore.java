/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.tonino.servlets;

import amm.tonino.classes.Vendor;
import amm.tonino.classes.Item;
import amm.tonino.classes.ItemFactory;
import amm.tonino.classes.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Venditore", urlPatterns = {"/venditore.html"})
public class Venditore extends HttpServlet {

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
            System.out.println("SESSION EXISTS");
            if(session.getAttribute("loggedVendor") != null){
                Vendor currVendor = (Vendor) session.getAttribute("loggedVendor");
                request.setAttribute("vendor", session.getAttribute("loggedVendor"));
                
                if(request.getParameter("SubmitItem") != null){
                    System.out.println("SUBMIT != NULL");
                    String name = request.getParameter("itemName");
                    String description = request.getParameter("itemDesc");
                    String category = request.getParameter("itemCat");
                    String imgUrl = request.getParameter("imgUrl");
                    int quantity = 0;
                    double price = 0;
                    if (request.getParameter("itemQuantity").matches("\\d+")){
                        System.out.println("QUANTITY VALID");
                        quantity = Integer.parseInt(request.getParameter("itemQuantity"));
                    }
                    if (request.getParameter("itemPrice").matches("[0-9]+(\\.[0-9][0-9]?)?")){
                        System.out.println("PRICE VALID");
                        price = Double.parseDouble(request.getParameter("itemPrice"));
                    }

                    if(name != null && description != null && category != null &&
                       imgUrl != null && quantity > 0 && price > 0){
                        System.out.println("ALL DATA != NULL");
                        Item itemPosted = new Item( 99, name, price, quantity, category, description, imgUrl, currVendor.getId());
                        ItemFactory.getInstance().addItem(name, description, quantity, price, category, imgUrl, currVendor.getId());
                        request.setAttribute("itemPosted", itemPosted);
                        request.setAttribute("vendor", true);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    } else {
                        System.out.println("SOME DATA = NULL");
                        System.out.println(name+" "+price+" "+quantity+" "+category+" "+description+" "+imgUrl);
                        request.setAttribute("input_error", true);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }
                } else if(request.getParameter("ModifyItem") != null){
                    String name = request.getParameter("itemName");
                    String description = request.getParameter("itemDesc");
                    String category = request.getParameter("itemCat");
                    String imgUrl = request.getParameter("imgUrl");
                    int quantity = 0;
                    double price = 0;
                    if (request.getParameter("itemQuantity").matches("\\d+")){
                        System.out.println("QUANTITY VALID");
                        quantity = Integer.parseInt(request.getParameter("itemQuantity"));
                    }
                    if (request.getParameter("itemPrice").matches("[0-9]+(\\.[0-9][0-9]?)?")){
                        System.out.println("PRICE VALID");
                        price = Double.parseDouble(request.getParameter("itemPrice"));
                    }

                    if(name != null && description != null && category != null &&
                       imgUrl != null && quantity > 0 && price > 0){
                        System.out.println("ALL DATA != NULL");
                        ItemFactory.getInstance().updateItem(Integer.parseInt(request.getParameter("ModifyItem")),name, description, quantity, price, category, imgUrl);
                        request.setAttribute("itemModified", true);
                        request.setAttribute("vendor", true);
                        request.getRequestDispatcher("vendUpdate.jsp").forward(request, response);
                    } else {
                        System.out.println("SOME DATA = NULL");
                        System.out.println(name+" "+price+" "+quantity+" "+category+" "+description+" "+imgUrl);
                        request.setAttribute("input_error", true);
                        request.getRequestDispatcher("venditore.jsp").forward(request, response);
                    }
                } else if (request.getParameter("UpdateItem") != null) {
                    if (request.getParameter("delItemId") != null){
                        ItemFactory.getInstance().deleteItem(Integer.parseInt(request.getParameter("delItemId")));
                    } else if (request.getParameter("modItemId") != null){
                        request.setAttribute("modItem", ItemFactory.getInstance().getItemById(Integer.parseInt(request.getParameter("modItemId"))));
                        request.getRequestDispatcher("vendUpdate.jsp").forward(request, response);
                    }
                    request.setAttribute("itemList", ItemFactory.getInstance().getItemByVendId(currVendor.getId()));
                    request.getRequestDispatcher("vendUpdate.jsp").forward(request, response);
                }else {
                    request.getRequestDispatcher("venditore.jsp").forward(request, response);
                }                
                    
            } else {
                request.setAttribute("login_error", true);
                request.getRequestDispatcher("venditore.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("login_error", true);
            request.getRequestDispatcher("venditore.jsp").forward(request, response);
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