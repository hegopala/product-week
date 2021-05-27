package com.maintenance.system.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is LoginUser class
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
@Builder
public class User {

    @Id
    @Column(name = "EMP_ID")
    private Integer empId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "EMP_PASSWORD")
    private String password;

    @Column(name = "EMP_STATUS")
    private String user_status;

    @Column(name = "CONTACT_NUMBER")
    private long contactNumber;

}
