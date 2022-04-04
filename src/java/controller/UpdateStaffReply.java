package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.Feedback;
import modelServices.FeedbackService;

/**
 *
 * @author kuxinyau
 */
public class UpdateStaffReply extends HttpServlet {
    
    @PersistenceContext
    EntityManager em;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            FeedbackService feedbackService = new FeedbackService(em);
            List<Feedback> feedbackList = feedbackService.findAllOrderByCodeDesc();
            
            String success = "fail";
            
            for (Feedback feedback: feedbackList) {
                String test = request.getParameter("btn" + feedback.getFeedbackcode());
                //request.getParameter("btn" + feedback.getFeedbackcode()).equals("btn" + feedback.getFeedbackcode())
                if (request.getParameter("btn" + feedback.getFeedbackcode()) != null)
                {
                    if (request.getParameter(feedback.getFeedbackcode()).isEmpty())
                        break;
                    
                    utx.begin();
                    success = feedbackService.updateFeedbackStaffReply(feedback.getFeedbackcode(), request.getParameter(feedback.getFeedbackcode()));
                    utx.commit();
                    break;
                }
            }
            
            List<Feedback> newFeedbackList = feedbackService.findAllOrderByCodeDesc();  
            
            HttpSession session = request.getSession();
            session.setAttribute("success", success);
            session.setAttribute("feedbackList", newFeedbackList);
            response.sendRedirect("secureStaff/StaffReplyComment.jsp");
            
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
