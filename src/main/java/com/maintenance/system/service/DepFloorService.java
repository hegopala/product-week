package com.maintenance.system.service;

import com.maintenance.system.exception.FailedToAddException;
import com.maintenance.system.model.Department;
import com.maintenance.system.model.Floor;
import com.maintenance.system.repository.DepartmentRepo;
import com.maintenance.system.repository.FloorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This is service class for the department and floor
 *
 * @author Gordhan Goyal
 */
@Service
@Slf4j
public class DepFloorService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    FloorRepo floorRepo;

    /**
     * This url helps to add department
     *
     * @param department [Department]
     * @return return the added department list
     */
    public List<Department> addDep(Department department) {
        List<Department> departmentList = new ArrayList<>();
        try {
            departmentRepo.save(department);
            departmentList.add(department);
            return departmentList;
        } catch (Exception e) {
            throw new FailedToAddException();
        }

    }

    /**
     * This url helps the get all department
     *
     * @return returns the list of department
     */
    public List<Department> getDep() {
        if (departmentRepo.findAll().size() == 0) {
            log.warn("No Department info available");
        }
        return departmentRepo.findAll();
    }

    /**
     * This method used for add the floor details
     *
     * @param floor [Floor]
     * @return returns the added floor
     */
    public List<Floor> addFloor(Floor floor) {
        List<Floor> floorList = new ArrayList<>();
        try {
            floorRepo.save(floor);
            floorList.add(floor);
            return floorList;
        } catch (Exception e) {
            throw new FailedToAddException();
        }

    }

    /**
     * This method used for get the floor details based on department id
     *
     * @param depId [Integer]
     * @return returns the list of floor
     */
    public List<Floor> getFloor(Integer depId) {
        List<Floor> floorList = floorRepo.findByDepId(depId);
        if (floorList.size() == 0) {
            log.warn("No floor info available");
        }
        return floorList;
    }


}
