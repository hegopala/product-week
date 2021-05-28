package com.maintenance.system.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is model class for the asset
 *
 * @author Gordhan Goyal
 */
@Entity
@Table(name = "ASSET")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Asset {

    @Id
    @Column(name = "ASSET_ID")
    private Integer asset_id;

    @Column(name = "ASSET_NAME")
    private String asset_name;

    @Column(name = "ASSET_TYPE")
    private String asset_type;

    @Column(name = "ASSET_FLOOR_ID")
    private Integer asset_floor_id;

    @Column(name = "ASSET_DEP_ID")
    private Integer asset_department_id;

}
