package com.maintenance.system.service;

import com.maintenance.system.model.DashboardData;
import com.maintenance.system.repository.DashboardRepo;
import com.maintenance.system.repository.DepartmentRepo;
import com.maintenance.system.repository.FloorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is service class to find the required asset
 *
 * @author Gordhan Goyal, Sunil
 */
@Service
public class AssetFilterService {

    @Autowired
    DashboardRepo dashboardRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    FloorRepo floorRepo;

    /**
     * This is service method for the asset filter
     *
     * @param depName   [String]
     * @param floorName [String]
     * @param assetType [String]
     * @return returns the list of asset data
     */
    public List<DashboardData> find(String depName, String floorName, String assetType) {
        if (depName != null) {
            if (floorName != null) {
                if (assetType != null) {
                    return filterByAssetType(depName, floorName, assetType);
                }
                return filterByFloorName(depName, floorName);
            }
            return filterByDepName(depName);
        }
        return dashboardRepo.fetchDataRightJoin();

    }

    /**
     * This service method used for filter the asset details based on department name
     *
     * @param dep_name [String]
     * @return returns the list of asset
     */
    public List<DashboardData> filterByDepName(String dep_name) {
        Integer dep_id = departmentRepo.getDepIdByDepName(dep_name.replaceAll("\"", "").trim());
        return dashboardRepo.filterByDepId(dep_id);
    }

    /**
     * This service method used for filter the asset details based on department name and floor name
     *
     * @param depName   [String]
     * @param floorName [String]
     * @return returns the list of asset
     */
    List<DashboardData> filterByFloorName(String depName, String floorName) {
        Integer dep_id = departmentRepo.getDepIdByDepName(depName.replaceAll("\"", "").trim());
        Integer floor_id = floorRepo.getFloorIdByName(floorName.replaceAll("\"", "").trim());
        return dashboardRepo.filterByDepAndFloor(dep_id, floor_id);
    }

    /**
     * This service method used for filter the asset details based on department and floor and asset Type
     *
     * @param depName   [String]
     * @param floorName [String]
     * @param assetType [String]
     * @return returns the list of asset
     */
    List<DashboardData> filterByAssetType(String depName, String floorName, String assetType) {
        Integer dep_id = departmentRepo.getDepIdByDepName(depName.replaceAll("\"", "").trim());
        Integer floor_id = floorRepo.getFloorIdByName(floorName.replaceAll("\"", "").trim());
        return dashboardRepo.filterByDepFloorAssetType(dep_id, floor_id, assetType.replaceAll("\"", "").trim());
    }
}
