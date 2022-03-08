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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author melvi
 */
@Entity
@Table(name = "PAYMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
    , @NamedQuery(name = "Payment.findByPaymentid", query = "SELECT p FROM Payment p WHERE p.paymentid = :paymentid")
    , @NamedQuery(name = "Payment.findByPaymentdatetime", query = "SELECT p FROM Payment p WHERE p.paymentdatetime = :paymentdatetime")
    , @NamedQuery(name = "Payment.findByPaymentamount", query = "SELECT p FROM Payment p WHERE p.paymentamount = :paymentamount")
    , @NamedQuery(name = "Payment.findByPaymentstatus", query = "SELECT p FROM Payment p WHERE p.paymentstatus = :paymentstatus")
    , @NamedQuery(name = "Payment.findByDeliveryfee", query = "SELECT p FROM Payment p WHERE p.deliveryfee = :deliveryfee")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PAYMENTID")
    private String paymentid;
    @Column(name = "PAYMENTDATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentdatetime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAYMENTAMOUNT")
    private Float paymentamount;
    @Size(max = 20)
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

    public Payment(String paymentid, Date paymentdatetime, Float paymentamount, String paymentstatus, Float deliveryfee, Orders orderid) {
        this.paymentid = paymentid;
        this.paymentdatetime = paymentdatetime;
        this.paymentamount = paymentamount;
        this.paymentstatus = paymentstatus;
        this.deliveryfee = deliveryfee;
        this.orderid = orderid;
    }
    

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
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
