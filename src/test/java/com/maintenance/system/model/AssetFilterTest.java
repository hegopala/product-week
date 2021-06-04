package com.maintenance.system.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssetFilterTest {

    @Test
    void setDepartmentName() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        a.setDepartmentName("Staffing and Recruiting");
        assertEquals("Staffing and Recruiting",a.getDepartmentName());
    }

    @Test
    void setFloorLevel() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        a.setFloorLevel("6C");
        assertEquals("6C",a.getFloorLevel());
    }

    @Test
    void setAssetType() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        a.setAssetType("Desktop");
        assertEquals("Desktop",a.getAssetType());
    }

    @Test
    void setParameter() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        a.setParameter("Pressure");
        assertEquals("Pressure",a.getParameter());
    }

    @Test
    void setDep_id() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        a.setDep_id(10001);
        assertEquals(10001,a.getDep_id());
    }

    @Test
    void setFloorId() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        a.setFloorId(8);
        assertEquals(8,a.getFloorId());
    }

    @Test
    void getDepartmentName() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        assertEquals("Information and technology",a.getDepartmentName());
    }

    @Test
    void getFloorLevel() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        assertEquals("3A",a.getFloorLevel());
    }

    @Test
    void getAssetType() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        assertEquals("Laptop",a.getAssetType());
    }

    @Test
    void getParameter() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        assertEquals("velocity",a.getParameter());
    }

    @Test
    void getDep_id() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        assertEquals(101,a.getDep_id());
    }

    @Test
    void getFloorId() {
        AssetFilter a=new AssetFilter("Information and technology","3A","Laptop","velocity",101,1001);
        assertEquals(1001,a.getFloorId());
    }
}