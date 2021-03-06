/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author melvi
 */
@Entity
@Table(name = "FEEDBACK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f")
    , @NamedQuery(name = "Feedback.findByFeedbackcode", query = "SELECT f FROM Feedback f WHERE f.feedbackcode = :feedbackcode")
    , @NamedQuery(name = "Feedback.findByRating", query = "SELECT f FROM Feedback f WHERE f.rating = :rating")
    , @NamedQuery(name = "Feedback.findByComments", query = "SELECT f FROM Feedback f WHERE f.comments = :comments")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "FEEDBACKCODE")
    private String feedbackcode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RATING")
    private int rating;
    @Size(max = 5)
    @Column(name = "COMMENTS")
    private String comments;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne(optional = false)
    private Customer customerid;
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "PRODUCTID")
    @ManyToOne(optional = false)
    private Product productid;

    public Feedback() {
    }

    public Feedback(String feedbackcode) {
        this.feedbackcode = feedbackcode;
    }

    public Feedback(String feedbackcode, int rating) {
        this.feedbackcode = feedbackcode;
        this.rating = rating;
    }

    public Feedback(String feedbackcode, int rating, String comments, Customer customerid, Product productid) {
        this.feedbackcode = feedbackcode;
        this.rating = rating;
        this.comments = comments;
        this.customerid = customerid;
        this.productid = productid;
    }

    public String getFeedbackcode() {
        return feedbackcode;
    }

    public void setFeedbackcode(String feedbackcode) {
        this.feedbackcode = feedbackcode;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public Product getProductid() {
        return productid;
    }

    public void setProductid(Product productid) {
        this.productid = productid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (feedbackcode != null ? feedbackcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.feedbackcode == null && other.feedbackcode != null) || (this.feedbackcode != null && !this.feedbackcode.equals(other.feedbackcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Feedback[ feedbackcode=" + feedbackcode + " ]";
    }

}
