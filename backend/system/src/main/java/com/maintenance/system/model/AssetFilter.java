package com.maintenance.system.model;

import lombok.*;

/**
 * This is model class to filter the asset
 *
 * @author Gordhan Goyal, Sunil
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AssetFilter {

    private String departmentName;
    private String floorLevel;
    private String assetType;
    private String parameter;

    private Integer dep_id;
    private Integer floorId;

}
