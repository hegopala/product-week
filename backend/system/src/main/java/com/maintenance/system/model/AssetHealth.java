package com.maintenance.system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * This is model class for the asset health
 *
 * @author Gordhan Goyal
 */
@Entity
@Table(name = "ASSET_HEALTH")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class AssetHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @JsonIgnore
    private Integer id;


    @Column(name = "ASSETID")
    private Integer assetId;

    @Column(name = "VELOCITY_VALUE")
    private Integer velocity_value;

    @Column(name = "PRESSURE_VALUE")
    private Integer pressure_value;

    @Column(name = "HEALTH_TIMESTAMP")
    private Date health_timestamp;


}
