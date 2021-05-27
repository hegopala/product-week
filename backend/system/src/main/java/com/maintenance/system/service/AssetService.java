package com.maintenance.system.service;

import com.maintenance.system.asset.AssetDetails;
import com.maintenance.system.asset.AssetHealthGenerator;
import com.maintenance.system.model.Asset;
import com.maintenance.system.model.AssetHealth;
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
    AssetDetails assetDetails;

    @Autowired
    AssetHealthGenerator assetHealthGenerator;

    /**
     * This service method is for get all assets
     *
     * @return list of all assets
     */
    public List<Asset> getAllAssets() {
        return assetDetails.getAllAssets();
    }

    /**
     * This method uses for generate the asset health
     *
     * @return returns the list of asset health
     */
    public List<AssetHealth> generateAssetHealth() {
        return assetHealthGenerator.generateAssetHealth();
    }

    /**
     * This method fetch the asset health history from repository
     *
     * @return returns list of asset health object
     */
    public List<AssetHealth> getAssetHealthHistory(Integer asset_id) {
        return assetDetails.getAssetHealthHistory(asset_id);
    }

    /**
     * This is service method used to add asset
     *
     * @param asset [Asset]
     * @return returns the added asset
     */
    public List<Asset> addAsset(Asset asset) {
        return assetDetails.addAsset(asset);
    }
}
