/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@NamedQueries({    
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByAccountid", query = "SELECT a FROM Account a WHERE a.accountId = :accountid")})
public class Account extends AbstractEntity implements Serializable {

    @Id
    @Column(name = "ACCOUNT_ID", updatable = false)
    @GeneratedValue
    private Long accountId;

    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @NotNull
    @Size(min = 6)
    @Column(name = "USER_PASSWORD")
    private String password;

    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "NAME", nullable = false)
    private String name;
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "SURNAME", nullable = false)
    private String surname;

    private boolean active;
    @NotNull
    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(min = 1, max = 64)
    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Size(max = 16)
    @Column(name = "PHONE")
    private String phone;

    public Account() {
    }

    @Override
    public Long getId() {
        return accountId;
    }

    @Override
    protected Object getBusinessKey() {
        return login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
