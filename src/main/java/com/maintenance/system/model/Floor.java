package com.maintenance.system.model;

import lombok.*;

import javax.persistence.*;

/**
 * This is floor model class
 *
 * @author Gordhan Goyal
 */
@Entity
@Table(name = "FLOOR")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Floor {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FLOOR_ID")
    private Integer floor_id;

    @Column(name = "FLOOR_NAME")
    private String floor_name;

    @Column(name = "DEPID")
    private Integer depId;

}
