package com.maintenance.system.model;

import lombok.*;

/**
 * This is class used for the register the new user
 *
 * @author Gordhan Goyal
 */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class RegisterUser {

    private String factoryName;
    private String factoryLocation;
    private String industryType;

    private String password;

    private Integer empId;
    private String email;
    private long contactNumber;

    private String securityQuestion;
    private String securityAnswer;


}
