package com.maintenance.system.repository;

import com.maintenance.system.model.AssetHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is interface for the asset health repository
 *
 * @author Gordhan Goyal
 */

@Repository
public interface AssetHealthRepository extends JpaRepository<AssetHealth, Integer> {


    @Query(value = "SELECT * FROM ASSET_HEALTH a WHERE a.ASSET_ID=?", nativeQuery = true)
    public List<AssetHealth> findByAssetId(Integer asset_id);
}
