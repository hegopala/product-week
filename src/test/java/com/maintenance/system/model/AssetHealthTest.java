package com.maintenance.system.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AssetHealthTest {

    @Test
    void getId() {
        AssetHealth a=new AssetHealth(1001,101,53,32,new Date(2017, 2, 1));
        assertEquals(1001,a.getId());
    }

    @Test
    void getAssetId() {
        AssetHealth a=new AssetHealth(1001,101,53,32,new Date(2017, 2, 1));
        assertEquals(101,a.getAssetId());
    }

    @Test
    void getVelocity_value() {
        AssetHealth a=new AssetHealth(1001,101,53,32, new Date(2017, 2, 1));
        assertEquals(53,a.getVelocity_value());
    }

    @Test
    void getPressure_value() {
        AssetHealth a=new AssetHealth(1001,101,53,32,new Date(2017, 2, 1));
        assertEquals(32,a.getPressure_value());
    }

    @Test
    void getHealth_timestamp() {
        AssetHealth a=new AssetHealth(1001,101,53,32,new Date(2017, 2, 1));
        assertEquals(new Date(2017, 2, 1),a.getHealth_timestamp());
    }
}