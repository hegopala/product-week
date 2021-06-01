package com.maintenance.system.repository;

import com.maintenance.system.model.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is floor repo
 *
 * @author Gordhan Goyal, Sunil
 */
@Repository
public interface FloorRepo extends JpaRepository<Floor, Integer> {

    @Query(value = "SELECT * FROM FLOOR f WHERE f.DEPID=?", nativeQuery = true)
    List<Floor> findByDepId(Integer depId);

    @Query(value = "SELECT f.FLOOR_ID FROM FLOOR f WHERE f.FLOOR_NAME=?", nativeQuery = true)
    Integer getFloorIdByName(String floorName);


}
