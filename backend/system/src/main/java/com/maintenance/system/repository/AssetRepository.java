package com.maintenance.system.repository;

import com.maintenance.system.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is interface for the asset repository
 *
 * @author Gordhan Goyal
 */
@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {


    @Query(value = "SELECT * FROM ASSET a WHERE a.ASSET_DEP_ID=? AND a.asset_floor_id =?", nativeQuery = true)
    List<Asset> findAssetType(Integer depId, Integer floorId);
}
