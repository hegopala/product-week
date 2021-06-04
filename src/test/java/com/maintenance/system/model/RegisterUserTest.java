package com.maintenance.system.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterUserTest {

    @Test
    void getFactoryName() {
        RegisterUser r=new RegisterUser("BMW","Munich","Automobile","991872@w",1,"BMW@bmw.com",7666543,"Favourite food","Lasagna");
        assertEquals("BMW",r.getFactoryName());
    }

    @Test
    void getFactoryLocation() {
        RegisterUser r=new RegisterUser("BMW","Munich","Automobile","991872@w",1,"BMW@bmw.com",7666543,"Favourite food","Lasagna");
        assertEquals("Munich",r.getFactoryLocation());
    }

    @Test
    void getIndustryType() {
        RegisterUser r=new RegisterUser("BMW","Munich","Automobile","991872@w",1,"BMW@bmw.com",7666543,"Favourite food","Lasagna");
        assertEquals("Automobile",r.getIndustryType());
    }

    @Test
    void getPassword() {
        RegisterUser r=new RegisterUser("BMW","Munich","Automobile","991872@w",1,"BMW@bmw.com",7666543,"Favourite food","Lasagna");
        assertEquals("991872@w",r.getPassword());
    }

    @Test
    void getEmpId() {
        RegisterUser r=new RegisterUser("BMW","Munich","Automobile","991872@w",1,"BMW@bmw.com",7666543,"Favourite food","Lasagna");
        assertEquals(1,r.getEmpId());
    }

    @Test
    void getEmail() {
        RegisterUser r=new RegisterUser("BMW","Munich","Automobile","991872@w",1,"BMW@bmw.com",7666543,"Favourite food","Lasagna");
        assertEquals("BMW@bmw.com",r.getEmail());
    }

    @Test
    void getContactNumber() {
        RegisterUser r=new RegisterUser("BMW","Munich","Automobile","991872@w",1,"BMW@bmw.com",7666543,"Favourite food","Lasagna");
        assertEquals(7666543,r.getContactNumber());
    }

    @Test
    void getSecurityQuestion() {
        RegisterUser r=new RegisterUser("BMW","Munich","Automobile","991872@w",1,"BMW@bmw.com",7666543,"Favourite food","Lasagna");
        assertEquals("Favourite food",r.getSecurityQuestion());
    }

    @Test
    void getSecurityAnswer() {
        RegisterUser r=new RegisterUser("BMW","Munich","Automobile","991872@w",1,"BMW@bmw.com",7666543,"Favourite food","Lasagna");
        assertEquals("Lasagna",r.getSecurityAnswer());
    }
}