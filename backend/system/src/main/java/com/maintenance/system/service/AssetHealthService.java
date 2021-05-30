package com.maintenance.system.service;

import com.maintenance.system.exception.FailedToAddAssetHealthException;
import com.maintenance.system.exception.NoSuchAssetFoundException;
import com.maintenance.system.model.AssetHealth;
import com.maintenance.system.repository.AssetHealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This is service class for the asset health
 *
 * @author Gordhan Goyal
 */
@Service
public class AssetHealthService {

    @Autowired
    AssetHealthRepository assetHealthRepository;

    /**
     * This method used to save the asset health to db
     *
     * @param assetHealth [AssetHealth]
     * @return returns list of saved AssetHealth
     */
    public List<AssetHealth> saveAssetHealth(AssetHealth assetHealth) {
        List<AssetHealth> assetHealthList = new ArrayList<>();
        try {
            assetHealthRepository.save(assetHealth);
            assetHealthList.add(assetHealth);
            return assetHealthList;
        } catch (Exception e) {
            throw new FailedToAddAssetHealthException();
        }
    }

    /**
     * This method used for fetch the latest health of asset
     *
     * @param asset_id [Integer] takes input for asset id
     * @return returns list of the asset health
     */
    public List<AssetHealth> getLatestHealth(Integer asset_id) {
        List<AssetHealth> assetHealthList = assetHealthRepository.getLatest(asset_id);
        if (assetHealthList.size() == 0) {
            throw new NoSuchAssetFoundException();
        }
        return assetHealthList;
    }

    /**
     * This method used for fetch the history of  asset health
     *
     * @param asset_id [Integer] takes input for asset id
     * @return returns list of the asset health
     */
    public List<AssetHealth> getAssetHealthHistory(Integer asset_id) {
        List<AssetHealth> assetHealthList = assetHealthRepository.getAssetHealth(asset_id);
        if (assetHealthList.size() == 0) {
            throw new NoSuchAssetFoundException();
        }
        return assetHealthList;
    }
}
