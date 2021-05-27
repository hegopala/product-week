package com.maintenance.system.service;

import com.maintenance.system.model.User;
import com.maintenance.system.user.LoggedInUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This is UserService class
 *
 * @author Sunil Hansda
 */
@Service
public class UserService {

    @Autowired
    private LoggedInUserDetails loggedInUserDetails;

    /**
     * This method fetches logged in user from repository
     *
     * @return User object
     */
    public User getLoggedInUser() {
        return loggedInUserDetails.getLoggedInUser();
    }

    /**
     * This service method is used for validate the user information
     *
     * @param user [User] object (String email,String password, Integer emp_id)
     * @return return true in case of successful login or else false
     */
    public boolean validateUser(User user) {
        return loggedInUserDetails.validateUser(user);
    }


}
