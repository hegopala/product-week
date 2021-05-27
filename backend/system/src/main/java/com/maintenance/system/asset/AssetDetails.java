package com.maintenance.system.asset;

import com.maintenance.system.exception.NoSuchAssetFoundException;
import com.maintenance.system.model.Asset;
import com.maintenance.system.model.AssetHealth;
import com.maintenance.system.repository.AssetHealthRepository;
import com.maintenance.system.repository.AssetRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will find out the all asset and it's information
 *
 * @author Gordhan Goyal
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
public class AssetDetails {


    @Autowired
    AssetRepository assetRepository;

    @Autowired
    AssetHealthRepository assetHealthRepository;


    /**
     * This method returns all the assets and it's information
     * This method throws the NoSuchAssetFoundException Exception
     *
     * @return list of the assets
     */
    public List<Asset> getAllAssets() {
        List<Asset> assetList = assetRepository.findAll();
        if (assetList.size() == 0) throw new NoSuchAssetFoundException();
        return assetList;
    }


    /**
     * This method fetch the asset health history from repository
     *
     * @return returns list of asset health object
     */
    public List<AssetHealth> getAssetHealthHistory(Integer asset_id) {
        List<AssetHealth> assetHealthList = assetHealthRepository.findByAssetId(asset_id);
        if (assetHealthList.size() == 0) {
            throw new NoSuchAssetFoundException();
        }
        return assetHealthList;
    }

    /**
     * This method used for add the asset
     *
     * @param asset [Asset] (Integer asset_id, String asset_name, String asset_type, Integer asset_floor_id, Integer asset_department_id)
     * @return returns the list of added assets
     */
    public List<Asset> addAsset(Asset asset) {
        List<Asset> assetList = new ArrayList<>();
        assetRepository.save(asset);
        assetList.add(asset);
        return assetList;
    }

}
