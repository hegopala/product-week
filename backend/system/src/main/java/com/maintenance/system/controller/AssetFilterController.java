package com.maintenance.system.controller;

import com.maintenance.system.model.DashboardData;
import com.maintenance.system.service.AssetFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is controller for the filter the asset
 *
 * @author Gordhan Goyal, Sunil
 */
@RestController
@RequestMapping("assetFilter")
public class AssetFilterController {

    @Autowired
    AssetFilterService assetFilterService;

    /**
     * This Get Url will help to filter the asset
     * @param depName [department] optional
     * @param floorName [floorName] optional
     * @param assetType [assetType] optional
     * @return returns list of asset info
     */
    @GetMapping("/result")
    public List<DashboardData> find(
            @RequestParam(value = "department", required = false) String depName,
            @RequestParam(value = "floorName", required = false) String floorName,
            @RequestParam(value = "assetType", required = false) String assetType) {
        return assetFilterService.find(depName, floorName, assetType);
    }
}
