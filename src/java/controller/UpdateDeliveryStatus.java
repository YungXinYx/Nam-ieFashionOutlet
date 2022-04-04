package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.Delivery;
import modelServices.DeliveryService;

/**
 *
 * @author kuxinyau
 */
public class UpdateDeliveryStatus extends HttpServlet {
    
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            DeliveryService deliveryService = new DeliveryService(em);
            List<Delivery> deliveryList = deliveryService.findAllOrderByidDesc();
            
            String success = "fail";
            
            for (Delivery delivery: deliveryList) {
                utx.begin();
                //delivery.setDeliverystatus(request.getParameter(delivery.getDeliveryid()));
                //em.persist(delivery);
                success = deliveryService.updateDeliveryStatus(delivery.getDeliveryid(), request.getParameter(delivery.getDeliveryid()));
                utx.commit();
            }
            
            List<Delivery> newDeliveryList = deliveryService.findAllOrderByidDesc();
            
            HttpSession session = request.getSession();
            session.setAttribute("success", success);
            session.setAttribute("deliveryList", newDeliveryList);
            response.sendRedirect("secureStaff/UpdateDeliveryStatus.jsp");
            
        } catch (Exception ex) {
            
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