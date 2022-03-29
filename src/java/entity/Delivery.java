/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "DELIVERY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d")
    , @NamedQuery(name = "Delivery.findByDeliveryid", query = "SELECT d FROM Delivery d WHERE d.deliveryid = :deliveryid")
    , @NamedQuery(name = "Delivery.findByDeliverydatetime", query = "SELECT d FROM Delivery d WHERE d.deliverydatetime = :deliverydatetime")
    , @NamedQuery(name = "Delivery.findByDeliverystatus", query = "SELECT d FROM Delivery d WHERE d.deliverystatus = :deliverystatus")
    , @NamedQuery(name = "Delivery.findByReceivername", query = "SELECT d FROM Delivery d WHERE d.receivername = :receivername")
    , @NamedQuery(name = "Delivery.findByAddressline1", query = "SELECT d FROM Delivery d WHERE d.addressline1 = :addressline1")
    , @NamedQuery(name = "Delivery.findByAddressline2", query = "SELECT d FROM Delivery d WHERE d.addressline2 = :addressline2")
    , @NamedQuery(name = "Delivery.findByPostcode", query = "SELECT d FROM Delivery d WHERE d.postcode = :postcode")
    , @NamedQuery(name = "Delivery.findByCountry", query = "SELECT d FROM Delivery d WHERE d.country = :country")
    , @NamedQuery(name = "Delivery.findByReceiverphonenumber", query = "SELECT d FROM Delivery d WHERE d.receiverphonenumber = :receiverphonenumber")})
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DELIVERYID")
    private String deliveryid;
    @Column(name = "DELIVERYDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliverydatetime;
    @Column(name = "DELIVERYSTATUS")
    private String deliverystatus;
    @Basic(optional = false)
    @Column(name = "RECEIVERNAME")
    private String receivername;
    @Basic(optional = false)
    @Column(name = "ADDRESSLINE1")
    private String addressline1;
    @Column(name = "ADDRESSLINE2")
    private String addressline2;
    @Basic(optional = false)
    @Column(name = "POSTCODE")
    private int postcode;
    @Basic(optional = false)
    @Column(name = "COUNTRY")
    private String country;
    @Basic(optional = false)
    @Column(name = "RECEIVERPHONENUMBER")
    private String receiverphonenumber;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID")
    @ManyToOne(optional = false)
    private Orders orderid;

    public Delivery() {
    }

    public Delivery(String deliveryid) {
        this.deliveryid = deliveryid;
    }

    public Delivery(String deliveryid, String receivername, String addressline1, int postcode, String country, String receiverphonenumber) {
        this.deliveryid = deliveryid;
        this.receivername = receivername;
        this.addressline1 = addressline1;
        this.postcode = postcode;
        this.country = country;
        this.receiverphonenumber = receiverphonenumber;
    }

    public String getDeliveryid() {
        return deliveryid;
    }

    public void setDeliveryid(String deliveryid) {
        this.deliveryid = deliveryid;
    }

    public Date getDeliverydatetime() {
        return deliverydatetime;
    }

    public void setDeliverydatetime(Date deliverydatetime) {
        this.deliverydatetime = deliverydatetime;
    }

    public String getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername;
    }

    public String getAddressline1() {
        return addressline1;
    }

    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    public String getAddressline2() {
        return addressline2;
    }

    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
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

    public String getReceiverphonenumber() {
        return receiverphonenumber;
    }

    public void setReceiverphonenumber(String receiverphonenumber) {
        this.receiverphonenumber = receiverphonenumber;
    }

    public Orders getOrderid() {
        return orderid;
    }

    public void setOrderid(Orders orderid) {
        this.orderid = orderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliveryid != null ? deliveryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.deliveryid == null && other.deliveryid != null) || (this.deliveryid != null && !this.deliveryid.equals(other.deliveryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Delivery[ deliveryid=" + deliveryid + " ]";
    }
    
}
