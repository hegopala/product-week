package com.maintenance.system.repository;

import com.maintenance.system.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is interface for the asset repository
 * @author Gordhan Goyal
 */
@Repository
public interface AssetRepository extends JpaRepository<Asset,Integer> {
}
