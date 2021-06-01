package com.maintenance.system.controller;

import com.maintenance.system.model.Asset;
import com.maintenance.system.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is controller to get all asset information
 *
 * @author Gordhan Goyal
 */

@RestController
@RequestMapping("/asset")
public class AssetInfoController {

    @Autowired
    private AssetService assetService;

    /**
     * This api used to get asset type based on department and floor
     *
     * @param depName   [department] optional
     * @param floorName [floorName] optional
     * @return return the list of asset
     */
    @GetMapping("/get")
    public List<Asset> getAllAssets(@RequestParam(value = "department", required = false) String depName,
                                    @RequestParam(value = "floorName", required = false) String floorName) {
        return assetService.getAllAssets(depName, floorName);
    }

    /**
     * This api will use for add the asset
     *
     * @param asset [Asset] (Integer asset_id, String asset_name, String asset_type, Integer asset_floor_id, Integer asset_department_id)
     * @return return the list of added assets
     */
    @PostMapping("/add")
    public List<Asset> addAsset(@RequestBody Asset asset) {
        return assetService.addAsset(asset);
    }


}
