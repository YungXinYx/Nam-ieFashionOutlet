/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author melvi
 */
@Entity
@Table(name = "MEMBERSHIP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membership.findAll", query = "SELECT m FROM Membership m")
    , @NamedQuery(name = "Membership.findByMembershipid", query = "SELECT m FROM Membership m WHERE m.membershipid = :membershipid")
    , @NamedQuery(name = "Membership.findByDiscount", query = "SELECT m FROM Membership m WHERE m.discount = :discount")
    , @NamedQuery(name = "Membership.findByPoints", query = "SELECT m FROM Membership m WHERE m.points = :points")})
public class Membership implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "MEMBERSHIPID")
    private String membershipid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISCOUNT")
    private Float discount;
    @Column(name = "POINTS")
    private Integer points;
    @OneToMany(mappedBy = "membershipid")
    private List<Customer> customerList;

    public Membership() {
    }

    public Membership(String membershipid) {
        this.membershipid = membershipid;
    }

    public Membership(String membershipid, Float discount, Integer points, List<Customer> customerList) {
        this.membershipid = membershipid;
        this.discount = discount;
        this.points = points;
        this.customerList = customerList;
    }

    public String getMembershipid() {
        return membershipid;
    }

    public void setMembershipid(String membershipid) {
        this.membershipid = membershipid;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (membershipid != null ? membershipid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membership)) {
            return false;
        }
        Membership other = (Membership) object;
        if ((this.membershipid == null && other.membershipid != null) || (this.membershipid != null && !this.membershipid.equals(other.membershipid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Membership[ membershipid=" + membershipid + " ]";
    }

}
