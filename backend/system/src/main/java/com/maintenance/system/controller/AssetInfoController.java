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
     * This api used to get all the asset
     *
     * @return returns the list of the all asset
     */
    @GetMapping("/getAllAssets")
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    /**
     * This api will use for add the asset
     *
     * @param asset [Asset] (Integer asset_id, String asset_name, String asset_type, Integer asset_floor_id, Integer asset_department_id)
     * @return return the list of added assets
     */
    @PostMapping("/addAsset")
    public List<Asset> addAsset(@RequestBody Asset asset) {
        return assetService.addAsset(asset);
    }
}
