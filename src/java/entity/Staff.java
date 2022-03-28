/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "STAFF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s")
    , @NamedQuery(name = "Staff.findByStaffid", query = "SELECT s FROM Staff s WHERE s.staffid = :staffid")
    , @NamedQuery(name = "Staff.findByStaffname", query = "SELECT s FROM Staff s WHERE s.staffname = :staffname")
    , @NamedQuery(name = "Staff.findByStaffic", query = "SELECT s FROM Staff s WHERE s.staffic = :staffic")
    , @NamedQuery(name = "Staff.findByAddressline1", query = "SELECT s FROM Staff s WHERE s.addressline1 = :addressline1")
    , @NamedQuery(name = "Staff.findByAddressline2", query = "SELECT s FROM Staff s WHERE s.addressline2 = :addressline2")
    , @NamedQuery(name = "Staff.findByPostcode", query = "SELECT s FROM Staff s WHERE s.postcode = :postcode")
    , @NamedQuery(name = "Staff.findByCountry", query = "SELECT s FROM Staff s WHERE s.country = :country")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "STAFFID")
    private String staffid;
    @Size(max = 50)
    @Column(name = "STAFFNAME")
    private String staffname;
    @Size(max = 50)
    @Column(name = "STAFFIC")
    private String staffic;
    @Size(max = 40)
    @Column(name = "ADDRESSLINE1")
    private String addressline1;
    @Size(max = 40)
    @Column(name = "ADDRESSLINE2")
    private String addressline2;
    @Column(name = "POSTCODE")
    private Integer postcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COUNTRY")
    private String country;

    public Staff() {
    }

    public Staff(String staffid) {
        this.staffid = staffid;
    }

    public Staff(String staffid, String country) {
        this.staffid = staffid;
        this.country = country;
    }

    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }

    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    public String getStaffic() {
        return staffic;
    }

    public void setStaffic(String staffic) {
        this.staffic = staffic;
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

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffid != null ? staffid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffid == null && other.staffid != null) || (this.staffid != null && !this.staffid.equals(other.staffid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Staff[ staffid=" + staffid + " ]";
    }
    
}
