package com.maintenance.system.model;

import javax.persistence.*;
import java.util.Date;

/**
 * This is model class for the asset health
 * @author Gordhan Goyal
 */
@Entity
@Table(name = "asset_health")
public class AssetHealth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer asset_id;
    private Integer velocity_value;
    private Integer pressure_value;
    private Date health_timestamp;

    /**
     * non-arg constructor
     */
    public AssetHealth() {
    }

    /**
     * Parameterized constructor for generate asset health
     * @param asset_id  [Integer] asset_id
     * @param velocity_value [integer] velocity_value
     * @param pressure_value [Integer] pressure_value
     * @param health_timestamp [java.utl.Date] health_timestamp
     */
    public AssetHealth(Integer asset_id, Integer velocity_value, Integer pressure_value, Date health_timestamp) {
        //this.id = id;
        this.asset_id = asset_id;
        this.velocity_value = velocity_value;
        this.pressure_value = pressure_value;
        this.health_timestamp = health_timestamp;
    }

    public Integer getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(Integer asset_id) {
        this.asset_id = asset_id;
    }

    public Integer getVelocity_value() {
        return velocity_value;
    }

    public void setVelocity_value(Integer velocity_value) {
        this.velocity_value = velocity_value;
    }

    public Integer getPressure_value() {
        return pressure_value;
    }

    public void setPressure_value(Integer pressure_value) {
        this.pressure_value = pressure_value;
    }

    public Date getHealth_timestamp() {
        return health_timestamp;
    }

    public void setHealth_timestamp(Date health_timestamp) {
        this.health_timestamp = health_timestamp;
    }

    @Override
    public String toString() {
        return "AssetHealth{" +
                "asset_id=" + asset_id +
                ", velocity_value=" + velocity_value +
                ", pressure_value=" + pressure_value +
                ", health_timestamp=" + health_timestamp +
                '}';
    }
}
