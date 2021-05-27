package com.maintenance.system.service;

import com.maintenance.system.exception.InvalidEmailFormatException;
import com.maintenance.system.exception.MismatchedPasswordException;
import com.maintenance.system.exception.UserNotFoundException;
import com.maintenance.system.exception.UserRegistrationException;
import com.maintenance.system.model.Factory;
import com.maintenance.system.model.RegisterUser;
import com.maintenance.system.model.SecurityQA;
import com.maintenance.system.model.User;
import com.maintenance.system.repository.FactoryRepo;
import com.maintenance.system.repository.SecurityQARepo;
import com.maintenance.system.repository.UserRepository;
import com.maintenance.system.util.CustomFunctions;
import com.maintenance.system.util.PasswordUtil;
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
    FactoryRepo factoryRepo;
    @Autowired
    SecurityQARepo securityQARepo;
    @Autowired
    UserRepository userRepository;

    /**
     * This method fetches logged in user from repository
     *
     * @return User object
     */
    public User getLoggedInUser() {
        User user = userRepository.getLoggedInUser();
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    /**
     * This service method is used for validate the user information
     *
     * @param user [User] object (String email,String password, Integer emp_id)
     * @return return true in case of successful login or else false
     */
    public boolean validateUser(User user) {
        //validate email format
        if (CustomFunctions.isValidEmail(user.getEmail())) {
            String hashedPassword = userRepository.findByEmail(user.getEmail());
            //validate password
            if (PasswordUtil.checkPassword(user.getPassword(), hashedPassword)) {
                return true;
            } else {
                throw new MismatchedPasswordException();
            }
        } else {
            throw new InvalidEmailFormatException();
        }

    }

    /**
     * This is user register method which helps to add nee user
     *
     * @param registerUser [RegisterUser]
     * @return returns true in case of success or else false
     */
    public boolean registerUser(RegisterUser registerUser) {
        try {
            User user = User.builder()
                    .empId(registerUser.getEmpId())
                    .email(registerUser.getEmail())
                    .password(PasswordUtil.encryptPassword(registerUser.getPassword()))
                    .contactNumber(registerUser.getContactNumber())
                    .build();

            userRepository.save(user);

            Factory factory = Factory.builder()
                    .factoryName(registerUser.getFactoryName())
                    .factoryLocation(registerUser.getFactoryLocation())
                    .industryType(registerUser.getIndustryType())
                    .build();

            factoryRepo.save(factory);

            SecurityQA securityQA = SecurityQA.builder()
                    .securityQuestion(registerUser.getSecurityQuestion())
                    .securityAnswer(registerUser.getSecurityAnswer())
                    .build();

            securityQARepo.save(securityQA);

            return true;

        } catch (Exception e) {
            throw new UserRegistrationException();
        }

    }


}
