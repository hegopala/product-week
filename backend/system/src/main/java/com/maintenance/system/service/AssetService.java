package com.maintenance.system.service;

import com.maintenance.system.model.Asset;
import com.maintenance.system.model.AssetHealth;
import com.maintenance.system.output.AllAssetDetails;
import com.maintenance.system.output.AssetHealthGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is service class to get all asset information
 *
 * @author Gordhan Goyal
 */

@Service
public class AssetService {
    @Autowired
    AllAssetDetails allAssetDetails;

    @Autowired
    AssetHealthGenerator assetHealthGenerator;

    /**
     * This service method is for get all assets
     *
     * @return list of all assets
     */
    public List<Asset> getAllAssets() {
        return allAssetDetails.getAllAssets();
    }

    /**
     * This method uses for generate the asset health
     * @return returns the list of asset health
     */
    public List<AssetHealth> generateAssetHealth() {
        return assetHealthGenerator.generateAssetHealth();
    }
}
