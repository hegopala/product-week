package com.maintenance.system.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is model class for the asset
 * @author Gordhan Goyal
 */
@Entity
@Table(name = "asset")
public class Asset {

    @Id
    private Integer asset_id;
    private String asset_name;
    private String asset_type;
    private Integer asset_floor_id;
    private Integer asset_department_id;

    /**
     * non-arg constructor
     */
    public Asset() {
    }

    /**
     * Parameterized constructor
     * @param asset_id [Integer] asset_id
     * @param asset_name [String] asset_name
     * @param asset_type [String] asset_type
     * @param asset_floor_id [Integer] asset_floor_id
     * @param asset_department_id [Integer] asset_department_id
     */

    public Asset(Integer asset_id, String asset_name, String asset_type, Integer asset_floor_id, Integer asset_department_id) {
        this.asset_id = asset_id;
        this.asset_name = asset_name;
        this.asset_type = asset_type;
        this.asset_floor_id = asset_floor_id;
        this.asset_department_id = asset_department_id;
    }


    public Integer getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(Integer asset_id) {
        this.asset_id = asset_id;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    public String getAsset_type() {
        return asset_type;
    }

    public void setAsset_type(String asset_type) {
        this.asset_type = asset_type;
    }

    public Integer getAsset_floor_id() {
        return asset_floor_id;
    }

    public void setAsset_floor_id(Integer asset_floor_id) {
        this.asset_floor_id = asset_floor_id;
    }

    public Integer getAsset_department_id() {
        return asset_department_id;
    }

    public void setAsset_department_id(Integer asset_department_id) {
        this.asset_department_id = asset_department_id;
    }

    @Override
    public String toString() {
        return "Asset{" +
                "asset_id=" + asset_id +
                ", asset_name='" + asset_name + '\'' +
                ", asset_type='" + asset_type + '\'' +
                ", asset_floor_id=" + asset_floor_id +
                ", asset_department_id=" + asset_department_id +
                '}';
    }
}
