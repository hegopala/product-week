package com.maintenance.system.output;

import com.maintenance.system.exception.NoSuchAssetFoundException;
import com.maintenance.system.model.Asset;
import com.maintenance.system.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This class will find out the all asset and it's information
 *
 * @author Gordhan Goyal
 */
@Component
public class AllAssetDetails {

    List<Asset> assetList;

    @Autowired
    AssetRepository assetRepository;

    /**
     * non-arg constructor
     */
    public AllAssetDetails() {
    }

    /**
     * parameterized constructor
     *
     * @param assetRepository AssetRepository
     */
    public AllAssetDetails(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    /**
     * This method returns all the assets and it's information
     * This method throws the NoSuchAssetFoundException Exception
     * @return list of the assets
     */
    public List<Asset> getAllAssets() {

        assetList = assetRepository.findAll();
        if (assetList.size() == 0) {
            throw new NoSuchAssetFoundException();
        }
        return assetList;
    }

}
