package com.maintenance.system.controller;

import com.maintenance.system.model.AssetHealth;
import com.maintenance.system.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
     * This method gives the list of generated asset health
     * @return returns the list of asset healthS
     */
    @PostMapping("/assetHealth")
    public List<AssetHealth> generateAssetHealth(){
        return assetService.generateAssetHealth();
    }

    /**
     * This method fetches the asset health history
     *
     * @return list of asset health object
     */
    @GetMapping("/assetHealthHistory")
    public List<AssetHealth> getAssetHealthHistory() {
        return assetService.getAssetHealthHistory();

    }
}
