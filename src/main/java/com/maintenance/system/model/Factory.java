package com.maintenance.system.model;

import lombok.*;

import javax.persistence.*;

/**
 * This is model class for Factory
 *
 * @author Gordhan Goyal
 */
@Entity
@Table(name = "FACTORY")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Factory {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "FACTORY_NAME")
    private String factoryName;

    @Column(name = "FACTORY_LOCATION")
    private String factoryLocation;

    @Column(name = "INDUSTRY_TYPE")
    private String industryType;
}
