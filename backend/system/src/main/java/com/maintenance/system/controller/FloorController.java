package com.maintenance.system.controller;

import com.maintenance.system.model.Floor;
import com.maintenance.system.service.DepFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("floor")
public class FloorController {

    @Autowired
    DepFloorService depFloorService;

    @PostMapping("/add")
    public String addFloor(@RequestBody Floor floor) {
        List<Floor> floorList = depFloorService.addFloor(floor);
        if (floorList.size() == 0) {
            return "Failed to add Floor";
        } else {
            return "Floor added successfully";
        }

    }

    @GetMapping("/get")
    public List<Floor> getFloor(@RequestParam(value = "dep-id") Integer depId) {
        return depFloorService.getFloor(depId);

    }

}
