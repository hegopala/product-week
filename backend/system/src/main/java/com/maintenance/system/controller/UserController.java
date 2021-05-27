package com.maintenance.system.controller;

import com.maintenance.system.model.User;
import com.maintenance.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is controller which fetches the logged in user data from database
 *
 * @author Sunil Hansda, Brijesh
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
    public User getLoggedInUser() {
        return userService.getLoggedInUser();
    }

    /**
     * This method is responsible for the user login validation
     *
     * @param user User object(String email, String password, Integer emp_id)
     */
    @PostMapping("/users/login")
    public boolean validateUser(@RequestBody User user) {
        return userService.validateUser(user);
    }


}
