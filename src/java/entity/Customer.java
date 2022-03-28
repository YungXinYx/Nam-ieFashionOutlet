/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author melvi
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByCustomerid", query = "SELECT c FROM Customer c WHERE c.customerid = :customerid")
    , @NamedQuery(name = "Customer.findByCustomername", query = "SELECT c FROM Customer c WHERE c.customername = :customername")
    , @NamedQuery(name = "Customer.findByCustomeric", query = "SELECT c FROM Customer c WHERE c.customeric = :customeric")
    , @NamedQuery(name = "Customer.findByAddress1", query = "SELECT c FROM Customer c WHERE c.address1 = :address1")
    , @NamedQuery(name = "Customer.findByAddress2", query = "SELECT c FROM Customer c WHERE c.address2 = :address2")
    , @NamedQuery(name = "Customer.findByPostcode", query = "SELECT c FROM Customer c WHERE c.postcode = :postcode")
    , @NamedQuery(name = "Customer.findByCountry", query = "SELECT c FROM Customer c WHERE c.country = :country")})
public class Customer implements Serializable {

    private static final String CUSTOMER_NUMBER_PREFIX = "C";
    private static int nextCustomerNumber = 1;

    public static int getNextCustomerNumber() {
        return nextCustomerNumber;
    }

    public static void setNextCustomerNumber(int nextCustomerNumber) {
        Customer.nextCustomerNumber = nextCustomerNumber;
    }

    public static String getCUSTOMER_NUMBER_PREFIX() {
        return CUSTOMER_NUMBER_PREFIX;
    }
    
    public static void increaseCustomerNumber() {
        nextCustomerNumber++;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CUSTOMERID")
    private String customerid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CUSTOMERNAME")
    private String customername;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CUSTOMERIC")
    private String customeric;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ADDRESS1")
    private String address1;
    @Size(max = 20)
    @Column(name = "ADDRESS2")
    private String address2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POSTCODE")
    private int postcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COUNTRY")
    private String country;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customerid")
    private CustomerAccount customerAccount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private List<Orders> ordersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
    private List<Feedback> feedbackList;

    public Customer() {
    }

    public Customer(String customerid) {
        this.customerid = customerid;
    }

    public Customer(String customerid, String customername, String customeric, String address1, String address2, int postcode, String country) {
        this.customerid = customerid;
        this.customername = customername;
        this.customeric = customeric;
        this.address1 = address1;
        this.address2 = address2;
        this.postcode = postcode;
        this.country = country;
    }

    public String getCustomerid() {
        return customerid;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCustomeric() {
        return customeric;
    }

    public void setCustomeric(String customeric) {
        this.customeric = customeric;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public CustomerAccount getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(CustomerAccount customerAccount) {
        this.customerAccount = customerAccount;
    }

    @XmlTransient
    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @XmlTransient
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerid != null ? customerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.customerid == null && other.customerid != null) || (this.customerid != null && !this.customerid.equals(other.customerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Customer[ customerid=" + customerid + " ]";
    }

}
