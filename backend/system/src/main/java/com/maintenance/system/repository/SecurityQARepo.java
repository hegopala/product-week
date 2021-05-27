package com.maintenance.system.repository;

import com.maintenance.system.model.SecurityQA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is interface for the Security Question and Answer
 *
 * @author Gordhan Goyal
 */
@Repository
public interface SecurityQARepo extends JpaRepository<SecurityQA, Integer> {
}
