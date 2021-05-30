package com.maintenance.system.job;

import com.maintenance.system.controller.AssetHealthController;
import com.maintenance.system.model.AssetHealth;
import com.maintenance.system.repository.AssetHealthRepository;
import com.maintenance.system.service.AssetHealthService;
import com.maintenance.system.util.CustomFunctions;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
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
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@EnableScheduling
public class AssetHealthJob {

    @Autowired
    AssetHealthService assetHealthService;
    @Autowired
    AssetHealthController assetHealthController;

    @Autowired
    AssetHealthRepository assetHealthRepository;

    /**
     * This method uses for generate the asset health
     * annotation @Scheduled(fixedDelay = milliseconds)
     * @return returns the list of generated asset health
     */
    @Scheduled(fixedDelay = 600000000)
    public List<AssetHealth> generateAssetHealth() {

        CustomFunctions cf = new CustomFunctions();
        List<AssetHealth> healthList = new ArrayList<>();
        String propFileName = "asset_health.properties";
        Map<String, Integer> map = cf.readProp(propFileName);

        int count = 0;
        int rows = cf.propValue(map, "result_set");
        while (count++ < rows) {
            try {
                AssetHealth assetHealth = AssetHealth.builder()
                        .assetId(CustomFunctions.random(cf.propValue(map, "min_asset"), cf.propValue(map, "max_asset")))
                        .velocity_value(CustomFunctions.random(cf.propValue(map, "min_velocity"), cf.propValue(map, "max_velocity")))
                        .pressure_value(CustomFunctions.random(cf.propValue(map, "min_pressure"), cf.propValue(map, "max_pressure")))
                        .health_timestamp(CustomFunctions.currentDateTime())
                        .build();

                assetHealthController.insertAssetHealth(assetHealth);
                healthList.add(assetHealth);
                assetHealthService.saveAssetHealth(assetHealth);

            } catch (Exception e) {
                log.error("[AssetHealthGenerator] [generateAssetHealth] " + e);
            }
        }
        return healthList;
    }

}
