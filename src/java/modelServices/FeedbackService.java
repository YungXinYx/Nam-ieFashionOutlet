package modelServices;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Feedback;

/**
 *
 * @author kuxinyau
 */
public class FeedbackService {
        
    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public FeedbackService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addFeedback(Feedback feedback) {
        mgr.persist(feedback);
        return true;
    }

    public Feedback findFeedbackByCode(String code) {
        Feedback feedback = mgr.find(Feedback.class, code);
        return feedback;
    }

    public boolean deleteFeedback(String id) {
        Feedback feedback = findFeedbackByCode(id);
        if (feedback != null) {
            mgr.remove(feedback);
            return true;
        }
        return false;
    }

    public List<Feedback> findAll() {
        List feedbackList = mgr.createNamedQuery("Feedback.findAll").getResultList();
        return feedbackList;
    }
    
    public List<Feedback> findAllOrderByCodeDesc() {
        List deliveryList = mgr.createNamedQuery("Feedback.findAllOrderByidDesc").getResultList();
        return deliveryList;
    }

    public String updateFeedbackStaffReply(String code, String reply) {
        Feedback tempFeedback = findFeedbackByCode(code);
        if (tempFeedback != null) {
            tempFeedback.setStaffreply(reply);
            return "success";
        }
        return "fail";
    }

}