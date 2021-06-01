package com.maintenance.system.controller;

import com.maintenance.system.model.Department;
import com.maintenance.system.service.DepFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    DepFloorService depFloorService;

    @PostMapping("/add")
    public String addDep(@RequestBody Department department) {
        List<Department> departmentList = depFloorService.addDep(department);
        if (departmentList.size() == 0) {
            return "Failed to add Department";
        } else {
            return "Department added successfully";
        }

    }

    @GetMapping("/get")
    public List<Department> getDep(){
        return depFloorService.getDep();

    }
}
