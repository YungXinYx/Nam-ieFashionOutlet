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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author user
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByProductid", query = "SELECT p FROM Product p WHERE p.productid = :productid")
    , @NamedQuery(name = "Product.findByProductname", query = "SELECT p FROM Product p WHERE p.productname = :productname")
    , @NamedQuery(name = "Product.findByProductprice", query = "SELECT p FROM Product p WHERE p.productprice = :productprice")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRODUCTID")
    private String productid;
    @Basic(optional = false)
    @Column(name = "PRODUCTNAME")
    private String productname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRODUCTPRICE")
    private Float productprice;
    @Basic(optional = false)
    @Lob
    @Column(name = "PRODUCTIMAGE1")
    private Serializable productimage1;
    @Lob
    @Column(name = "PRODUCTIMAGE2")
    private Serializable productimage2;
    @Lob
    @Column(name = "PRODUCTIMAGE3")
    private Serializable productimage3;
    @JoinColumn(name = "CATEGORYID", referencedColumnName = "CATEGORYID")
    @ManyToOne(optional = false)
    private Category categoryid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productid")
    private List<ProductDetails> productDetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productid")
    private List<Feedback> feedbackList;

    public Product() {
    }

    public Product(String productid) {
        this.productid = productid;
    }

    public Product(String productid, String productname, Serializable productimage1) {
        this.productid = productid;
        this.productname = productname;
        this.productimage1 = productimage1;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Float getProductprice() {
        return productprice;
    }

    public void setProductprice(Float productprice) {
        this.productprice = productprice;
    }

    public Serializable getProductimage1() {
        return productimage1;
    }

    public void setProductimage1(Serializable productimage1) {
        this.productimage1 = productimage1;
    }

    public Serializable getProductimage2() {
        return productimage2;
    }

    public void setProductimage2(Serializable productimage2) {
        this.productimage2 = productimage2;
    }

    public Serializable getProductimage3() {
        return productimage3;
    }

    public void setProductimage3(Serializable productimage3) {
        this.productimage3 = productimage3;
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }

    @XmlTransient
    public List<ProductDetails> getProductDetailsList() {
        return productDetailsList;
    }

    public void setProductDetailsList(List<ProductDetails> productDetailsList) {
        this.productDetailsList = productDetailsList;
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
        hash += (productid != null ? productid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productid == null && other.productid != null) || (this.productid != null && !this.productid.equals(other.productid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ productid=" + productid + " ]";
    }
    
}
