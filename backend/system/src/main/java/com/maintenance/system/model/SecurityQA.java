package com.maintenance.system.model;


import lombok.*;

import javax.persistence.*;

/**
 * This is model class for SecurityQA
 *
 * @author Gordhan Goyal
 */
@Entity
@Table(name = "SECURITY_QA")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class SecurityQA {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "SECURITY_QUES")
    private String securityQuestion;

    @Column(name = "SECURITY_ANS")
    private String securityAnswer;


}
