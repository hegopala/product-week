package com.maintenance.system.controller;

import com.maintenance.system.model.Asset;
import com.maintenance.system.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * This is controller to get all asset information
 * @author Gordhan Goyal
 */

@RestController
public class AssetInfoController {

    @Autowired
    private AssetService assetService;

    /**
     * This method used to get all the asset
     * @return returns the list of the all asset
     */
    @GetMapping("/getAllAssets")
    public List<Asset> getAllAssets(){
        return assetService.getAllAssets();
    }
}
