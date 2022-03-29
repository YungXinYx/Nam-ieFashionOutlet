/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
@Table(name = "PAYMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
    , @NamedQuery(name = "Payment.findByPaymentid", query = "SELECT p FROM Payment p WHERE p.paymentid = :paymentid")
    , @NamedQuery(name = "Payment.findByCreditcardnumber", query = "SELECT p FROM Payment p WHERE p.creditcardnumber = :creditcardnumber")
    , @NamedQuery(name = "Payment.findByCreditcardcvv", query = "SELECT p FROM Payment p WHERE p.creditcardcvv = :creditcardcvv")
    , @NamedQuery(name = "Payment.findByCreditcardexpireddate", query = "SELECT p FROM Payment p WHERE p.creditcardexpireddate = :creditcardexpireddate")
    , @NamedQuery(name = "Payment.findByPaymentdatetime", query = "SELECT p FROM Payment p WHERE p.paymentdatetime = :paymentdatetime")
    , @NamedQuery(name = "Payment.findByPaymentamount", query = "SELECT p FROM Payment p WHERE p.paymentamount = :paymentamount")
    , @NamedQuery(name = "Payment.findByPaymentstatus", query = "SELECT p FROM Payment p WHERE p.paymentstatus = :paymentstatus")
    , @NamedQuery(name = "Payment.findByDeliveryfee", query = "SELECT p FROM Payment p WHERE p.deliveryfee = :deliveryfee")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PAYMENTID")
    private String paymentid;
    @Basic(optional = false)
    @Column(name = "CREDITCARDNUMBER")
    private String creditcardnumber;
    @Basic(optional = false)
    @Column(name = "CREDITCARDCVV")
    private String creditcardcvv;
    @Column(name = "CREDITCARDEXPIREDDATE")
    @Temporal(TemporalType.DATE)
    private Date creditcardexpireddate;
    @Column(name = "PAYMENTDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentdatetime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAYMENTAMOUNT")
    private Float paymentamount;
    @Column(name = "PAYMENTSTATUS")
    private String paymentstatus;
    @Column(name = "DELIVERYFEE")
    private Float deliveryfee;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID")
    @ManyToOne(optional = false)
    private Orders orderid;

    public Payment() {
    }

    public Payment(String paymentid) {
        this.paymentid = paymentid;
    }

    public Payment(String paymentid, String creditcardnumber, String creditcardcvv) {
        this.paymentid = paymentid;
        this.creditcardnumber = creditcardnumber;
        this.creditcardcvv = creditcardcvv;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getCreditcardnumber() {
        return creditcardnumber;
    }

    public void setCreditcardnumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }

    public String getCreditcardcvv() {
        return creditcardcvv;
    }

    public void setCreditcardcvv(String creditcardcvv) {
        this.creditcardcvv = creditcardcvv;
    }

    public Date getCreditcardexpireddate() {
        return creditcardexpireddate;
    }

    public void setCreditcardexpireddate(Date creditcardexpireddate) {
        this.creditcardexpireddate = creditcardexpireddate;
    }

    public Date getPaymentdatetime() {
        return paymentdatetime;
    }

    public void setPaymentdatetime(Date paymentdatetime) {
        this.paymentdatetime = paymentdatetime;
    }

    public Float getPaymentamount() {
        return paymentamount;
    }

    public void setPaymentamount(Float paymentamount) {
        this.paymentamount = paymentamount;
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public Float getDeliveryfee() {
        return deliveryfee;
    }

    public void setDeliveryfee(Float deliveryfee) {
        this.deliveryfee = deliveryfee;
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
        hash += (paymentid != null ? paymentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentid == null && other.paymentid != null) || (this.paymentid != null && !this.paymentid.equals(other.paymentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Payment[ paymentid=" + paymentid + " ]";
    }
    
}
