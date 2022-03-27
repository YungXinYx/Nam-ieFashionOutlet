/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import modelServices.CustomerDetailsService;

public class AddCustomerDetails extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;
    int idCount = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String customerName = request.getParameter("customername");
            String customerIC = request.getParameter("customeric");
            String gender = request.getParameter("gender");
            String address1 = request.getParameter("address1");
            String address2 = request.getParameter("address2");
            int postcode = Integer.parseInt(request.getParameter("postcode"));
            String country = request.getParameter("country");

            Customer customer = new Customer();

            customer.setCustomername(customerName);
            customer.setCustomeric(customerIC);
            customer.setGender(gender);
            customer.setAddress1(address1);
            customer.setAddress2(address2);
            customer.setPostcode(postcode);
            customer.setCountry(country);

            int count = ((Number) em.createNamedQuery("Customer.findAllCount").getSingleResult()).intValue();

            for (int i = 0; i < count; i++) {
                idCount++;
            }
            
            customer.setCustomerid("C" + idCount);

            CustomerDetailsService customerDetailsService = new CustomerDetailsService(em);

            utx.begin();
            boolean success = customerDetailsService.addCustomer(customer);
            utx.commit();
            HttpSession session = request.getSession();
            session.setAttribute("sucess", success);
            response.sendRedirect("confirmUser.jsp");

        } catch (Exception ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
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
