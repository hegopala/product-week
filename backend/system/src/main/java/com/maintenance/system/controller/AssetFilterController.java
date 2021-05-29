package com.maintenance.system.controller;

import com.maintenance.system.model.AssetFilter;
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

    @GetMapping("/result")
    public List<DashboardData> find(
            @RequestParam(value = "department", required = false) String depName,
            @RequestParam(value = "floorName", required = false) String floorName,
            @RequestParam(value = "assetType", required = false) String assetType) {

        /*if (depName != null) {
            AssetFilter.builder()
                    .departmentName(depName.replaceAll("\"","").trim())
                    .build();
            if (floorName != null) {
                AssetFilter.builder()
                        .floorLevel(floorName.replaceAll("\"","").trim())
                        .build();
                if (assetType != null) {
                    AssetFilter.builder()
                            .assetType(assetType.replaceAll("\"","").trim())
                            .build();
                }
            }
        }*/
        return assetFilterService.find(depName, floorName, assetType);
    }
}
