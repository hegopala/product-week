package com.maintenance.system.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    @Test
    void getId() {
        Floor f=new Floor(1, 101, "Simpsons Floor",1);
        assertEquals(1,f.getId());
    }

    @Test
    void getFloor_id() {
        Floor f=new Floor(1, 101, "Simpsons Floor",1);
        assertEquals(101,f.getFloor_id());
    }

    @Test
    void getFloor_name() {
        Floor f=new Floor(1, 101, "Simpsons Floor",1);
        assertEquals("Simpsons Floor",f.getFloor_name());
    }

    @Test
    void getDepId() {
        Floor f=new Floor(1, 101, "Simpsons Floor",1);
        assertEquals(1,f.getDepId());
    }
}