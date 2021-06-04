package com.maintenance.system.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void getDep_id() {
        Department d=new Department(1, "Information and technology");
        assertEquals(1,d.getDep_id());
    }

    @Test
    void getDep_name() {
        Department d=new Department(1, "Information and technology");
        assertEquals("Information and technology",d.getDep_name());
    }
}