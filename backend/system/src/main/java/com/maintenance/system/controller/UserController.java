package com.maintenance.system.controller;

import com.maintenance.system.model.User;
import com.maintenance.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is controller which fetches the logged in user data from database
 *
 * @author Sunil Hansda
 */

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * This method returns the loggedIn user details
     *
     * @return user object
     */
    @GetMapping("/getUser")
    public User getUser() {
        return userService.getUser();
    }
}
