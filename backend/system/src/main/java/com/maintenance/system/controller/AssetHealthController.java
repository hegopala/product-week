package com.maintenance.system.controller;

import com.maintenance.system.model.AssetHealth;
import com.maintenance.system.service.AssetHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is controller which will generate the asset health
 *
 * @author Gordhan Goyal ,Sunil Hansda
 */
@RestController
@RequestMapping("/assetHealth")
public class AssetHealthController {

    @Autowired
    AssetHealthService assetHealthService;

    /**
     * This api will use for the add the asset health
     *
     * @param assetHealth [AssetHealth]
     * @return returns the list of added health
     */
    @PostMapping("/add")
    public List<AssetHealth> insertAssetHealth(@RequestBody AssetHealth assetHealth) {
        return assetHealthService.saveAssetHealth(assetHealth);
    }

    /**
     * This api fetches the latest asset health
     *
     * @param asset_id takes asset_id for the health
     * @return list of latest asset health
     */
    @GetMapping("/getLatest")
    //Call after every 10 seconds.
    public List<AssetHealth> getLatestHealth(@RequestParam(value = "asset-id") Integer asset_id) {
        return assetHealthService.getLatestHealth(asset_id);

    }

    /**
     * This api fetches the asset health history
     *
     * @param asset_id takes asset_id for the health
     * @return list of asset health
     */
    @GetMapping("/get")
    public List<AssetHealth> getAssetHealthHistory(@RequestParam(value = "asset-id") Integer asset_id) {
        return assetHealthService.getAssetHealthHistory(asset_id);

    }
}
