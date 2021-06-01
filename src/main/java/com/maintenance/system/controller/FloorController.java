package com.maintenance.system.controller;

import com.maintenance.system.model.Floor;
import com.maintenance.system.service.DepFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is floor controller
 *
 * @author Gordhan Goyal
 */
@RestController
@RequestMapping("floor")
public class FloorController {

    @Autowired
    DepFloorService depFloorService;

    /**
     * This url used to add new floor details
     *
     * @param floor [Object] floor
     * @return returns the success in case of successful add or else Failed
     */
    @PostMapping("/add")
    public String addFloor(@RequestBody Floor floor) {
        List<Floor> floorList = depFloorService.addFloor(floor);
        if (floorList.size() == 0) {
            return "Failed to add Floor";
        } else {
            return "Floor added successfully";
        }

    }


    /**
     * This url fetch the floor details based on department id
     *
     * @param depId [Integer] department id
     * @return returns the list of the floor
     */
    @GetMapping("/get")
    public List<Floor> getFloor(@RequestParam(value = "dep-id") Integer depId) {
        return depFloorService.getFloor(depId);

    }

}
