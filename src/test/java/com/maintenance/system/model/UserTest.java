package com.maintenance.system.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void getEmpId() {
        User user=new User(1,"John@xyz.com","123433","N",90192823);
        assertEquals(1,user.getEmpId());
    }

    @Test
    void getEmail() {
        User user=new User(1,"John@xyz.com","123433","N",90192823);
        assertEquals("John@xyz.com",user.getEmail());
    }

    @Test
    void getPassword() {
        User user=new User(1,"John@xyz.com","123433","N",90192823);
        assertEquals("123433",user.getPassword());
    }

    @Test
    void getUser_status() {
        User user=new User(1,"John@xyz.com","123433","N",90192823);
        assertEquals("N",user.getUser_status());
    }

    @Test
    void getContactNumber() {
        User user=new User(1,"John@xyz.com","123433","N",90192823);
        assertEquals(90192823,user.getContactNumber());
    }

    @Test
    void setEmpId() {
        User user=new User(1,"John@xyz.com","123433","N",90192823);
        user.setEmpId(2);
        assertEquals(2,user.getEmpId());
    }

    @Test
    void setEmail() {
        User user=new User(1,"John@xyz.com","123433","N",90192823);
        user.setEmail("Adam@abc.com");
        assertEquals("Adam@abc.com",user.getEmail());
    }

    @Test
    void setPassword() {
        User user=new User(1,"John@xyz.com","123433","N",90192823);
        user.setPassword("121@#$52");
        assertEquals("121@#$52",user.getPassword());
    }

    @Test
    void setUser_status() {
        User user=new User(1,"John@xyz.com","123433","N",90192823);
        user.setUser_status("Y");
        assertEquals("Y",user.getUser_status());
    }

    @Test
    void setContactNumber() {
        User user=new User(1,"John@xyz.com","123433","N",90192823);
        user.setContactNumber(87254143);
        assertEquals(87254143,user.getContactNumber());
    }


}