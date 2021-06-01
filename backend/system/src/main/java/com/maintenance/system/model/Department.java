package com.maintenance.system.model;

import lombok.*;

import javax.persistence.*;

/**
 * This is department model
 *
 * @author Gordhan Goyal
 */
@Entity
@Table(name = "DEPARTMENT")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Department {

    @Id
    @Column(name = "DEP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dep_id;

    @Column(name = "DEP_NAME")
    private String dep_name;
}
