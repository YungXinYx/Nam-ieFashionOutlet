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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author melvi
 */
@Entity
@Table(name = "CUSTOMER_ACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerAccount.findAll", query = "SELECT c FROM CustomerAccount c")
    , @NamedQuery(name = "CustomerAccount.findByUsername", query = "SELECT c FROM CustomerAccount c WHERE c.username = :username")
    , @NamedQuery(name = "CustomerAccount.findByPassword", query = "SELECT c FROM CustomerAccount c WHERE c.password = :password")
    , @NamedQuery(name = "CustomerAccount.findByEmail", query = "SELECT c FROM CustomerAccount c WHERE c.email = :email")})
public class CustomerAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "PASSWORD")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "EMAIL")
    private String email;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @OneToOne(optional = false)
    private Customer customerid;

    public CustomerAccount() {
    }

    public CustomerAccount(String username) {
        this.username = username;
    }

    public CustomerAccount(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public CustomerAccount(String username, String password, String email, Customer customerid) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.customerid = customerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerAccount)) {
            return false;
        }
        CustomerAccount other = (CustomerAccount) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CustomerAccount[ username=" + username + " ]";
    }
    
}
