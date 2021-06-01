package com.maintenance.system.repository;

import com.maintenance.system.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * This is interface for the department repo
 *
 * @author Gordhan Goyal
 */
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {


    @Query(value = "SELECT d.DEP_ID FROM DEPARTMENT d WHERE d.DEP_NAME=?", nativeQuery = true)
    Integer getDepIdByDepName(String depName);

}
