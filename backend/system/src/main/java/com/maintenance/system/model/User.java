package com.maintenance.system.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * This is User class
 *
 * @author Sunil Hansda
 */

@Entity
@Table
public class User {

    @Id
    private int empId;
    private String email;
    private String password;

    public User(){}

    public User(int empId, String email, String password) {
        this.empId = empId;
        this.email = email;
        this.password = password;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "empId=" + empId +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
