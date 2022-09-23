package com.project.model.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.model.Customer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class AppUser {

    @Id
    @Column(name = "username")
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column
    private Integer isDeleted = 0;

    @JsonIgnore
    @OneToMany(mappedBy = "appUser")
    private List<UserRole> userRoles;

    @OneToOne(mappedBy = "appUser")
    @JsonIgnore
    private Customer customer;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AppUser appUser = (AppUser) o;
        return userName != null && Objects.equals(userName, appUser.userName);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
