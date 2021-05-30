package com.maintenance.system.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private Integer dep_id;

    @Column(name = "DEP_NAME")
    private String dep_name;
}
