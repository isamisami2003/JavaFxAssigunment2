/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hp
 */
@Entity
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts_1.findAll", query = "SELECT a FROM Accounts_1 a")
    , @NamedQuery(name = "Accounts_1.findById", query = "SELECT a FROM Accounts_1 a WHERE a.id = :id")
    , @NamedQuery(name = "Accounts_1.findByUserId", query = "SELECT a FROM Accounts_1 a WHERE a.userId = :userId")
    , @NamedQuery(name = "Accounts_1.findByAccountNumber", query = "SELECT a FROM Accounts_1 a WHERE a.accountNumber = :accountNumber")
    , @NamedQuery(name = "Accounts_1.findByUsername", query = "SELECT a FROM Accounts_1 a WHERE a.username = :username")
    , @NamedQuery(name = "Accounts_1.findByCurrency", query = "SELECT a FROM Accounts_1 a WHERE a.currency = :currency")
    , @NamedQuery(name = "Accounts_1.findByBalance", query = "SELECT a FROM Accounts_1 a WHERE a.balance = :balance")
    , @NamedQuery(name = "Accounts_1.findByCreationDate", query = "SELECT a FROM Accounts_1 a WHERE a.creationDate = :creationDate")})
public class Accounts_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @Column(name = "account_number")
    private int accountNumber;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "currency")
    private String currency;
    @Basic(optional = false)
    @Column(name = "balance")
    private double balance;
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    public Accounts_1() {
    }

    public Accounts_1(Integer id) {
        this.id = id;
    }

    public Accounts_1(int id,int userId, int accountNumber, String username, String currency, double balance) {
        this.id=id;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.username = username;
        this.currency = currency;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts_1)) {
            return false;
        }
        Accounts_1 other = (Accounts_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Accounts_1[ id=" + id + " ]";
    }
    
}
