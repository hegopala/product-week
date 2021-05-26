package com.maintenance.system.controller;

import com.maintenance.system.model.AssetHealth;
import com.maintenance.system.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is controller which will generate the asset health
 * @author Gordhan Goyal
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
}
