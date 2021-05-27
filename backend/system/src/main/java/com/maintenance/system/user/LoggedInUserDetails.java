package com.maintenance.system.user;

import com.maintenance.system.exception.MismatchedPasswordException;
import com.maintenance.system.exception.UserNotFoundException;
import com.maintenance.system.model.User;
import com.maintenance.system.repository.UserRepository;
import com.maintenance.system.util.CustomFunctions;
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
    public User getLoggedInUser() {
        User user = userRepository.getLoggedInUser();
        if (user == null) {
            throw new UserNotFoundException();
        }
        return userRepository.getLoggedInUser();
    }

    /**
     * This method is used for validate the user credentials
     *
     * @param user [User] object (String email,String password, Integer emp_id)
     * @return return true in case of successful login or else false
     */
    public boolean validateUser(User user) {
        //validate email format
        if (CustomFunctions.isValidEmail(user.getEmail())) {
            String hashedPassword = userRepository.findByEmail(user.getEmail());
            //validate password
            if (PasswordEncryption.checkPassword(user.getPassword(), hashedPassword)) {
                return true;
            } else {
                throw new MismatchedPasswordException();
            }
        } else {
            return false;
        }

    }
}
