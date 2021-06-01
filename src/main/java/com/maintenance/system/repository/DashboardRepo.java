package com.maintenance.system.repository;

import com.maintenance.system.model.DashboardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is interface for the dashboard repo
 *
 * @author Gordhan Goyal, Sunil
 */
@Repository
public interface DashboardRepo extends JpaRepository<DashboardData, Integer> {

    String sql = "SELECT  H.velocity_value, H.pressure_value, H.health_timestamp, " +
            " A.asset_id, A.asset_name, A.asset_type, A.asset_floor_id, A.asset_dep_id " +
            " FROM ASSET_HEALTH H " +
            " RIGHT JOIN ASSET A ON A.ASSET_ID = H.ASSETID " +
            " WHERE id IN ( SELECT MAX(G.id) FROM ASSET_HEALTH G GROUP BY G.ASSETID ) ";

    @Query(value = sql, nativeQuery = true)
    List<DashboardData> fetchDataRightJoin();


    String sql2 = "SELECT  H.velocity_value, H.pressure_value, H.health_timestamp, " +
            " A.asset_id, A.asset_name, A.asset_type, A.asset_floor_id, A.asset_dep_id " +
            " FROM ASSET_HEALTH H " +
            " RIGHT JOIN ASSET A ON A.ASSET_ID = H.ASSETID " +
            " WHERE id IN ( SELECT MAX(G.id) FROM ASSET_HEALTH G GROUP BY G.ASSETID ) " +
            " AND A.asset_dep_id = ? ";

    @Query(value = sql2, nativeQuery = true)
    List<DashboardData> filterByDepId(Integer dep_id);


    String sql3 = "SELECT  H.velocity_value, H.pressure_value, H.health_timestamp, " +
            " A.asset_id, A.asset_name, A.asset_type, A.asset_floor_id, A.asset_dep_id " +
            " FROM ASSET_HEALTH H " +
            " RIGHT JOIN ASSET A ON A.ASSET_ID = H.ASSETID " +
            " WHERE id IN ( SELECT MAX(G.id) FROM ASSET_HEALTH G GROUP BY G.ASSETID ) " +
            " AND A.asset_dep_id = ? AND A.asset_floor_id = ?";

    @Query(value = sql3, nativeQuery = true)
    List<DashboardData> filterByDepAndFloor(Integer dep_id, Integer floorId);


    String sql4 = "SELECT  H.velocity_value, H.pressure_value, H.health_timestamp, " +
            " A.asset_id, A.asset_name, A.asset_type, A.asset_floor_id, A.asset_dep_id " +
            " FROM ASSET_HEALTH H " +
            " RIGHT JOIN ASSET A ON A.ASSET_ID = H.ASSETID " +
            " WHERE id IN ( SELECT MAX(G.id) FROM ASSET_HEALTH G GROUP BY G.ASSETID ) " +
            " AND A.asset_dep_id = ? AND A.asset_floor_id = ? AND A.asset_type = ?";

    @Query(value = sql4, nativeQuery = true)
    List<DashboardData> filterByDepFloorAssetType(Integer dep_id, Integer floorId, String assetType);
}
