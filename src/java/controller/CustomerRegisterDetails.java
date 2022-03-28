package controller;

import java.io.IOException;
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
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import model.Customer;

public class CustomerRegisterDetails extends HttpServlet {

    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession session = request.getSession();

            String customername = request.getParameter("customername");
            String customeric = request.getParameter("customeric");
            String address1 = request.getParameter("address1");
            String address2 = request.getParameter("address2");
            int postcode = Integer.parseInt(request.getParameter("postcode"));
            String country = request.getParameter("country");

            utx.begin();
            int rowCount = (Integer) em.createNativeQuery("SELECT count(1) FROM CUSTOMER").getSingleResult();
            Customer.setNextCustomerNumber(rowCount);
            Customer customer = new Customer(Customer.getCUSTOMER_NUMBER_PREFIX() + String.format("%02d", Customer.getNextCustomerNumber()), customername, customeric, address1, address2, postcode, country);
            Customer.increaseCustomerNumber();
            utx.commit();
            session.setAttribute("customer", customer);
            request.getRequestDispatcher("CustomerRegisterPage.html").forward(request, response);
        } catch (IllegalStateException | NumberFormatException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException ex) {
            Logger.getLogger(CustomerRegisterDetails.class.getName()).log(Level.SEVERE, null, ex);
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
