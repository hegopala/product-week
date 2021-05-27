package com.maintenance.system.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is User class
 *
 * @author Sunil Hansda
 */
@Entity
@Table(name = "USER_PROFILE")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User {

    @Id
    @Column(name = "EMP_ID")
    private Integer empId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USER_PASSWORD")
    private String password;

    @Column(name = "USER_STATUS")
    private String user_status;

}
