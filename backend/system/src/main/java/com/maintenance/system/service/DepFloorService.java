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

@Service
@Slf4j
public class DepFloorService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    FloorRepo floorRepo;

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

    public List<Department> getDep() {
        if (departmentRepo.findAll().size() == 0) {
            log.warn("No Department info available");
        }
        return departmentRepo.findAll();
    }



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

    public List<Floor> getFloor(Integer depId) {
        List<Floor> floorList = floorRepo.findByDepId(depId);
        if (floorList.size() == 0) {
            log.warn("No floor info available");
        }
        return floorList;
    }



}
