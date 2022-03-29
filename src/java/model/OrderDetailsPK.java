/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author user
 */
@Embeddable
public class OrderDetailsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ORDERID")
    private String orderid;
    @Basic(optional = false)
    @Column(name = "PRODUCTDETAILSID")
    private String productdetailsid;

    public OrderDetailsPK() {
    }

    public OrderDetailsPK(String orderid, String productdetailsid) {
        this.orderid = orderid;
        this.productdetailsid = productdetailsid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getProductdetailsid() {
        return productdetailsid;
    }

    public void setProductdetailsid(String productdetailsid) {
        this.productdetailsid = productdetailsid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        hash += (productdetailsid != null ? productdetailsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetailsPK)) {
            return false;
        }
        OrderDetailsPK other = (OrderDetailsPK) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        if ((this.productdetailsid == null && other.productdetailsid != null) || (this.productdetailsid != null && !this.productdetailsid.equals(other.productdetailsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderDetailsPK[ orderid=" + orderid + ", productdetailsid=" + productdetailsid + " ]";
    }
    
}
