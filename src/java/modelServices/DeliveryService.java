package modelServices;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;
import model.Delivery;

/**
 *
 * @author kuxinyau
 */

public class DeliveryService {
    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public DeliveryService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addDelivery(Delivery delivery) {
        mgr.persist(delivery);
        return true;
    }

    public Delivery findDeliveryByID(String id) {
        Delivery delivery = mgr.find(Delivery.class, id);
        return delivery;
    }

    public boolean deleteDelivery(String id) {
        Delivery delivery = findDeliveryByID(id);
        if (delivery != null) {
            mgr.remove(delivery);
            return true;
        }
        return false;
    }

    public List<Delivery> findAll() {
        List deliveryList = mgr.createNamedQuery("Delivery.findAll").getResultList();
        return deliveryList;
    }
    
    public List<Delivery> findAllOrderByidDesc() {
        List deliveryList = mgr.createNamedQuery("Delivery.findAllOrderByidDesc").getResultList();
        return deliveryList;
    }

    public String updateDeliveryStatus(String id, String status) {
        Delivery tempDelivery = findDeliveryByID(id);
        if (tempDelivery != null) {
            tempDelivery.setDeliverystatus(status);
            return "success";
        }
        return "fail";
    }
}
