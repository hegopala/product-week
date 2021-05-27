package com.maintenance.system.controller;

import com.maintenance.system.model.User;
import com.maintenance.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * This api returns the loggedIn user details
     *
     * @return user object
     */
    @GetMapping("/getUser")
    public User getLoggedInUser() {
        return userService.getLoggedInUser();
    }

    /**
     * This api is responsible for the user login validation
     *
     * @param user User object(String email, String password, Integer emp_id)
     * @return return true in case of successful login or else false
     */
    @PostMapping("/user/login")
    public boolean validateUser(@RequestBody User user) {
        return userService.validateUser(user);
    }

    /**
     * This api will help to register the new user
     *
     * @param user [user] user details (Integer emp_id, String email, String password)
     * @return returns the list of registered user
     */
    @PostMapping("/user/register")
    public List<User> registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

}
