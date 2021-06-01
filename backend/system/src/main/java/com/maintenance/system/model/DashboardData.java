package com.maintenance.system.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * This is model class for the dashboard data
 *
 * @author Gordhan Goyal, Sunil
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class DashboardData {


    @Id
    private Integer asset_id;
    private String asset_name;
    private String asset_type;
    private Integer asset_floor_id;
    private Integer asset_dep_id;
    private Integer velocity_value;
    private Integer pressure_value;
    private Date health_timestamp;
}
