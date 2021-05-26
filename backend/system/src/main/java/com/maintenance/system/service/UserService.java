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
    public User getUser() {
        return loggedInUserDetails.getUserFromRepository();
    }
}
