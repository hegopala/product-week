package com.maintenance.system.repository;

import com.maintenance.system.model.AssetHealth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is interface for the asset health repository
 * @author Gordhan Goyal
 */

@Repository
public interface AssetHealthRepository extends JpaRepository<AssetHealth,Integer> {


}
