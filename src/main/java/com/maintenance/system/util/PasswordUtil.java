package com.maintenance.system.util;

import lombok.NonNull;
import org.mindrot.jbcrypt.BCrypt;

/**
 * This class used to encrypt the password
 *
 * @author Gordhan Goyal
 */
public class PasswordUtil {

    /**
     * This method used for encrypt the password
     *
     * @param password [String] takes texted password
     * @return returns the encrypted password
     */
    public static String encryptPassword(@NonNull String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * This method used for check the encrypted password and texted password
     *
     * @param password [String] takes the texted password
     * @param hashed   [String] takes the hashed password
     * @return returns true in case of password is same or else false
     */
    public static boolean checkPassword(@NonNull String password, @NonNull String hashed) {
        return BCrypt.checkpw(password, hashed);
    }


}
