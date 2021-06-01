package com.maintenance.system.controller;

import com.maintenance.system.model.RegisterUser;
import com.maintenance.system.model.User;
import com.maintenance.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This is controller for register the user, validate the user and display the logged in user details
 *
 * @author Sunil Hansda, Brijesh, Gordhan Goyal
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * This api returns the loggedIn user details
     *
     * @return user object
     */
    @GetMapping("/get")
    public User getLoggedInUser() {
        return userService.getLoggedInUser();
    }

    /**
     * This api is responsible for the user validation
     *
     * @param user LoginUser object(String email, String password, Integer emp_id)
     * @return return success in case of successful validation or else failed
     */
    @PostMapping("/validate")
    public String validateUser(@RequestBody User user) {

        if (userService.validateUser(user)) {
            return "User Validation Successful";
        } else {
            return "User Validation Failed";
        }
    }

    /**
     * This api will help to register the new user
     *
     * @param registerUser [RegisterUser]
     * @return returns the Success of registered user or else failed
     */
    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterUser registerUser) {
        if (userService.registerUser(registerUser)) {
            return "Registration Successful";
        } else {
            return "Registration Failed";
        }
    }

}
