package com.maintenance.system.output;

import com.maintenance.system.model.AssetHealth;
import com.maintenance.system.repository.AssetHealthRepository;
import com.maintenance.system.util.CustomFunctions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class will generate the random asset health
 *
 * @author Gordhan Goyal
 */
@Component
public class AssetHealthGenerator {
    private static final Logger log = LoggerFactory.getLogger(AssetHealthGenerator.class);

    @Autowired
    AssetHealthRepository assetHealthRepository;

    /**
     * non argument constructor
     */
    public AssetHealthGenerator() {
    }

    /**
     * AssetHealthGenerator constructor
     *
     * @param assetHealthRepository AssetHealthRepository
     */
    public AssetHealthGenerator(AssetHealthRepository assetHealthRepository) {
        this.assetHealthRepository = assetHealthRepository;
    }

    /**
     * This method uses for generate the asset health
     *
     * @return returns the list of generated asset health
     */
    public List<AssetHealth> generateAssetHealth() {

        CustomFunctions cf = new CustomFunctions();
        List<AssetHealth> healthList = new ArrayList<>();
        String propFileName = "asset_health.properties";
        Map<String, Integer> map = cf.readProp(propFileName);

        int count = 0;
        int rows = cf.propValue(map, "result_set");
        while (count++ < rows) {
            try {
                // take min and max from properties file
                AssetHealth assetHealth = new AssetHealth(
                        CustomFunctions.random(cf.propValue(map, "min_asset"), cf.propValue(map, "max_asset")),
                        CustomFunctions.random(cf.propValue(map, "min_velocity"), cf.propValue(map, "max_velocity")),
                        CustomFunctions.random(cf.propValue(map, "min_pressure"), cf.propValue(map, "max_pressure")),
                        CustomFunctions.currentDateTime());
                assetHealthRepository.save(assetHealth);
                healthList.add(assetHealth);
            } catch (Exception e) {
                log.error("[AssetHealthGenerator] [generateAssetHealth] " + e);
            }
        }
        return healthList;
    }


}
