package com.maintenance.system.service;


import com.maintenance.system.exception.NoSuchAssetFoundException;
import com.maintenance.system.model.Asset;
import com.maintenance.system.repository.AssetRepository;
import com.maintenance.system.repository.DepartmentRepo;
import com.maintenance.system.repository.FloorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This is service class to get all asset information and asset health
 *
 * @author Gordhan Goyal
 */

@Service
@Slf4j
public class AssetService {

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    DepartmentRepo departmentRepo;

    @Autowired
    FloorRepo floorRepo;


    /**
     * This service method is for get all assets
     *
     * @return list of all assets , throws NoSuchAssetFoundException exception in case of empty list
     */
    public List<Asset> getAllAssets() {
        List<Asset> assetList = assetRepository.findAll();
        if (assetList.size() == 0) throw new NoSuchAssetFoundException();
        return assetList;
    }


    /**
     * This is service method used to add asset
     *
     * @param asset [Asset]
     * @return returns the added asset
     */
    public List<Asset> addAsset(Asset asset) {
        List<Asset> assetList = new ArrayList<>();
        try {
            assetRepository.save(asset);
            assetList.add(asset);
        } catch (Exception e) {
            log.error("[Failed to add asset !!! ] " + e);
        }
        return assetList;
    }


    /*public List<Asset> getAssetByDepId(String depName){

        // take dep id from depName
        Integer dep_id =  departmentRepo.findByDepName(depName);
        List<Asset> assetList = assetRepository.findByDepId(dep_id);
        if (assetList.size() == 0) throw new NoSuchAssetFoundException();
        return assetList;
    }*/

    public List<Asset> getAssetType(String depName, String floorName){
        Integer dep_id =  departmentRepo.getDepIdByDepName(depName);
        Integer floor_id = floorRepo.getFloorIdByName(floorName);
        return assetRepository.findAssetType(dep_id,floor_id);
    }


}
