package com.maintenance.system.controller;

import com.maintenance.system.model.AssetHealth;
import com.maintenance.system.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is controller which will generate the asset health
 * @author Gordhan Goyal ,Sunil Hansda
 */
@RestController
public class AssetHealthController {

    @Autowired
    AssetService assetService;


    /**
     * This api add asset health
     * @return returns the added list of asset health
     */
    @PostMapping("/addAssetHealth")
    public List<AssetHealth> generateAssetHealth(){
        return assetService.generateAssetHealth();
    }

    /**
     * This api fetches the asset health history
     *
     * @return list of asset health
     */
    @GetMapping("/assetHealth")
    public List<AssetHealth> getAssetHealthHistory(@RequestParam(value = "asset_id") Integer asset_id) {
        return assetService.getAssetHealthHistory(asset_id);

    }
}
