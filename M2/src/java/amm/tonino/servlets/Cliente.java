/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.tonino.servlets;

import amm.tonino.classes.Account;
import amm.tonino.classes.AccountFactory;
import amm.tonino.classes.Buyer;
import amm.tonino.classes.Item;
import amm.tonino.classes.ItemFactory;
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
        // check sessione
        HttpSession session = request.getSession();
        
        if(session != null){
            
            ArrayList<Item> itemList = ItemFactory.getInstance().getItemList();
            //check utente loggato
            if(session.getAttribute("loggedBuyer") != null){
                Buyer currBuyer = (Buyer) session.getAttribute("loggedBuyer");
                request.setAttribute("buyer", currBuyer);
                // logica di controllo acquisto
                if(request.getParameter("itemPurchase")!= null && request.getParameter("itemPurchase").matches("\\d+")){
                    System.out.println("Acquisto in corso");
                    int itemId = Integer.parseInt(request.getParameter("itemPurchase"));
                    Double userBalance = AccountFactory.getInstance().getAccountById(currBuyer.getId()).getBalance();
                    Double itemPrice = ItemFactory.getInstance().getItemById(itemId).getPrice();
                    if(itemPrice < userBalance){
                        System.out.println("Acquisto ok");
                        request.setAttribute("purchaseOk", true);
                        // in teoria scala i soldi dall'utente
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    } else {
                        System.out.println("Acquisto fallito");
                        request.setAttribute("purchaseFailed", true);
                        request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    }
                    // resoconto oggetto selezionato
                } else if(request.getParameter("itemId")!= null){
                    int itemId = Integer.parseInt(request.getParameter("itemId"));
                    Item item = ItemFactory.getInstance().getItemById(itemId);
                    request.setAttribute("itemDetails", item);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                    //elenco oggetti in vendita
                } else {
                    request.setAttribute("itemList", itemList);
                    request.getRequestDispatcher("cliente.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("login_error", true);
                request.getRequestDispatcher("cliente.jsp").forward(request, response);
            }
        } else {
                request.setAttribute("login_error", true);
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