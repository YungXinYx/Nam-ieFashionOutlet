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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "PRODUCT_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDetails.findAll", query = "SELECT p FROM ProductDetails p")
    , @NamedQuery(name = "ProductDetails.findByProductdetailsid", query = "SELECT p FROM ProductDetails p WHERE p.productdetailsid = :productdetailsid")
    , @NamedQuery(name = "ProductDetails.findByProductsize", query = "SELECT p FROM ProductDetails p WHERE p.productsize = :productsize")
    , @NamedQuery(name = "ProductDetails.findByQuantity", query = "SELECT p FROM ProductDetails p WHERE p.quantity = :quantity")})
public class ProductDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PRODUCTDETAILSID")
    private String productdetailsid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PRODUCTSIZE")
    private String productsize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productDetails")
    private List<OrderDetails> orderDetailsList;
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "PRODUCTID")
    @ManyToOne(optional = false)
    private Product productid;

    public ProductDetails() {
    }

    public ProductDetails(String productdetailsid) {
        this.productdetailsid = productdetailsid;
    }

    public ProductDetails(String productdetailsid, String productsize, int quantity) {
        this.productdetailsid = productdetailsid;
        this.productsize = productsize;
        this.quantity = quantity;
    }

    public ProductDetails(String productdetailsid, String productsize, int quantity, Product productid) {
        this.productdetailsid = productdetailsid;
        this.productsize = productsize;
        this.quantity = quantity;
        this.productid = productid;
    }

    public String getProductdetailsid() {
        return productdetailsid;
    }

    public void setProductdetailsid(String productdetailsid) {
        this.productdetailsid = productdetailsid;
    }

    public String getProductsize() {
        return productsize;
    }

    public void setProductsize(String productsize) {
        this.productsize = productsize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public List<OrderDetails> getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(List<OrderDetails> orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
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
        hash += (productdetailsid != null ? productdetailsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDetails)) {
            return false;
        }
        ProductDetails other = (ProductDetails) object;
        if ((this.productdetailsid == null && other.productdetailsid != null) || (this.productdetailsid != null && !this.productdetailsid.equals(other.productdetailsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProductDetails[ productdetailsid=" + productdetailsid + " ]";
    }
    
}
