package modelServices;

import entity.*;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class CustomerDetailsService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public CustomerDetailsService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public boolean addCustomer(Customer customer) {
        mgr.persist(customer);
        return true;
    }

    public Customer findCustomerById(String customerID) {
        Customer customer = mgr.find(Customer.class, customerID);
        return customer;
    }

    public boolean deleteItem(String customerID) {
        Customer customer = findCustomerById(customerID);
        if (customer != null) {
            mgr.remove(customer);
            return true;
        }
        return false;
    }

    public List<Customer> findAll() {
        List customerList = mgr.createNamedQuery("Customer.findAll").getResultList();
        return customerList;
    }

    public boolean updateItem(Customer customer) {
        Customer tempCustomer = findCustomerById(customer.getCustomerid());
        if (tempCustomer != null) {
            tempCustomer.setCustomername(customer.getCustomername());
            tempCustomer.setCustomeric(customer.getCustomeric());
            tempCustomer.setGender(customer.getGender());
            tempCustomer.setAddress1(customer.getAddress1());
            tempCustomer.setAddress2(customer.getAddress2());
            tempCustomer.setPostcode(customer.getPostcode());
            tempCustomer.setCountry(customer.getCountry());
            return true;
        }
        return false;
    }
}
