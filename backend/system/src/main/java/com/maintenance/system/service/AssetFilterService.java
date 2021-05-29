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

    public List<DashboardData> find(String depName, String floorName, String assetType) {
        if (depName != null && floorName == null) {
            return filterByDepName(depName);
        } else if (floorName != null && assetType == null) {
            return filterByFloorName(depName, floorName);
        } else if (assetType != null) {
            return filterByAssetType(depName,floorName,assetType);
        }
        return dashboardRepo.fetchDataRightJoin();

    }

    public List<DashboardData> filterByDepName(String dep_name) {
        Integer dep_id = departmentRepo.getDepIdByDepName(dep_name.replaceAll("\"","").trim());
        return dashboardRepo.filterByDepId(dep_id);
    }

    List<DashboardData> filterByFloorName(String depName, String floorName) {
        Integer dep_id = departmentRepo.getDepIdByDepName(depName.replaceAll("\"","").trim());
        Integer floor_id = floorRepo.getFloorIdByName(floorName.replaceAll("\"","").trim());
        return dashboardRepo.filterByDepAndFloor(dep_id, floor_id);
    }

    List<DashboardData> filterByAssetType(String depName, String floorName, String assetType) {
        Integer dep_id = departmentRepo.getDepIdByDepName(depName.replaceAll("\"","").trim());
        Integer floor_id = floorRepo.getFloorIdByName(floorName.replaceAll("\"","").trim());
        return dashboardRepo.filterByDepFloorAssetType(dep_id, floor_id, assetType.replaceAll("\"","").trim());
    }
}
