package com.maintenance.system.user;

import com.maintenance.system.exception.UserNotFoundException;
import com.maintenance.system.model.User;
import com.maintenance.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is LoggedInUserDetails class
 *
 * @author Sunil Hansda
 */

@Component
public class LoggedInUserDetails {

    @Autowired
    private UserRepository userRepository;

    /**
     * This method fetches logged in user from repository
     *
     * @return returns User object
     */
    public User getUserFromRepository() {
        User user = userRepository.getLoggedInUser();
        if (user == null) {
            throw new UserNotFoundException();
        }
        return userRepository.getLoggedInUser();
    }
}
