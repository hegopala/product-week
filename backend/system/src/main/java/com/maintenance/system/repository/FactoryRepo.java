package com.maintenance.system.repository;

import com.maintenance.system.model.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is interface for the Factory repo
 *
 * @author Gordhan Goyal
 */
@Repository
public interface FactoryRepo extends JpaRepository<Factory, Integer> {
}
