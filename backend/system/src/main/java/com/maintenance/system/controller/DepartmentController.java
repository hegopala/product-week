package com.maintenance.system.controller;

import com.maintenance.system.model.Department;
import com.maintenance.system.service.DepFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is department controller
 *
 * @author Gordhan Goyal
 */
@RestController
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    DepFloorService depFloorService;

    /**
     * This method used to add department
     *
     * @param department [Object] Department object
     * @return returns the success in case of successful add or else Failed
     */
    @PostMapping("/add")
    public String addDep(@RequestBody Department department) {
        List<Department> departmentList = depFloorService.addDep(department);
        if (departmentList.size() == 0) {
            return "Failed to add Department";
        } else {
            return "Department added successfully";
        }

    }

    /**
     * This url fetch the list of the department
     *
     * @return returns the list of th department
     */
    @GetMapping("/get")
    public List<Department> getDep() {
        return depFloorService.getDep();

    }
}
