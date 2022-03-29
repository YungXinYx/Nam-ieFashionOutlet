/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
        
import model.*;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.*;

public class CustomerService {

    @PersistenceContext
    EntityManager mgr;
    @Resource
    Query query;

    public CustomerService(EntityManager mgr) {
        this.mgr = mgr;
    }

    public CustomerService(EntityManager mgr, Query query) {
        this.mgr = mgr;
        this.query = query;
    }

    public boolean addCustomer(Customer customer) {
        mgr.persist(customer);
        return true;
    }

    //find customer
    public Customer findByCustomerid(String id) {
        Customer customer = mgr.find(Customer.class, id);
        return customer;
    }

    public boolean deleteCustomer(String id) {
        Customer customer = findByCustomerid(id);
        if (customer != null) {
            mgr.remove(customer);
            return true;
        }
        return false;
    }

    //default
    public List<Customer> findAll() {
        List customerList = mgr.createNamedQuery("Customer.findAll").getResultList();
        return customerList;
    }
    
    //sort by id
    public List<Customer> sortID() {
        List customerList = mgr.createNamedQuery("Customer.sortID").getResultList();
        return customerList;
    }

    //sort by name
    public List<Customer> sortName() {
        List customerList = mgr.createNamedQuery("Customer.sortName").getResultList();
        return customerList;
    }

    //sort by ic
    public List<Customer> sortIC() {
        List customerList = mgr.createNamedQuery("Customer.sortIC").getResultList();
        return customerList;
    }

//    public boolean updateCustomer(Customer customer) {
//        Customer tempData = findByCustomerid(customer.getCustomerid());
//        if (tempData != null) {
//            tempData.setCustomeric(customer.getCustomeric());
//            tempData.setCustomername(customer.getCustomername());
//            tempData.setCustomeric(customer.getCustomeric());
//            tempData.setCustomeric(customer.getCustomeric());
//            tempData.setCustomeric(customer.getCustomeric());
//            tempItem.setPrice(customer.getPrice());
//            return true;
//        }
//        return false;
//    }
}
