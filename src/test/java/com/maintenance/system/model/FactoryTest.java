package com.maintenance.system.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void getId() {
        Factory fac=new Factory(1001, "BMW", "Munich","Automobile");
        assertEquals(1001,fac.getId());
    }

    @Test
    void getFactoryName() {
        Factory fac=new Factory(1001, "BMW", "Munich","Automobile");
        assertEquals("BMW",fac.getFactoryName());
    }

    @Test
    void getFactoryLocation() {
        Factory fac=new Factory(1001, "BMW", "Munich","Automobile");
        assertEquals("Munich",fac.getFactoryLocation());
    }

    @Test
    void getIndustryType() {
        Factory fac=new Factory(1001, "BMW", "Munich","Automobile");
        assertEquals("Automobile",fac.getIndustryType());
    }
}