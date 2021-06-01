package com.maintenance.system.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This is Error advice controller
 *
 * @author Sunil, Gordhan Goyal, Brijesh
 */

@ControllerAdvice
@Slf4j
public class ErrorControllerAdvice {

    /**
     * This is used for throw NoSuchAssetFoundException in case if no asset found
     *
     * @param noSuchAssetFoundException this will throw NoSuchAssetFoundException
     */

    @ExceptionHandler(value = NoSuchAssetFoundException.class)
    public void exception(NoSuchAssetFoundException noSuchAssetFoundException) {
        log.error("[ASSET table does not have any asset info !!!] " + noSuchAssetFoundException);
    }

    /**
     * This is used for throw MismatchedPasswordException in case of incorrect password
     *
     * @param mismatchedPasswordException this will throw MismatchedPasswordException
     */
    @ExceptionHandler(value = MismatchedPasswordException.class)
    public void exception(MismatchedPasswordException mismatchedPasswordException) {
        log.error("Incorrect Password !!! " + mismatchedPasswordException);
    }


    /**
     * This is used for throw AssetHealthPropNotFoundException in case of asset_health.properties not found
     *
     * @param assetHealthPropNotFoundException [AssetHealthPropNotFoundException]
     */
    @ExceptionHandler(value = AssetHealthPropNotFoundException.class)
    public void exception(AssetHealthPropNotFoundException assetHealthPropNotFoundException) {
        log.error("asset_health.properties not found !!! " + assetHealthPropNotFoundException);
    }


    /**
     * This is used for throw UserNotFoundException in case of user not found
     *
     * @param userNotFoundException [UserNotFoundException]
     */
    @ExceptionHandler(value = UserNotFoundException.class)
    public void exception(UserNotFoundException userNotFoundException) {
        log.error("user not found !!! " + userNotFoundException);
    }

    /**
     * This is used for throw InvalidEmailFormatException in case of incorrect email
     *
     * @param invalidEmailFormatException [InvalidEmailFormatException]
     */
    @ExceptionHandler(value = InvalidEmailFormatException.class)
    public void exception(InvalidEmailFormatException invalidEmailFormatException) {
        log.error("Invalid Email Exception !!! " + invalidEmailFormatException);
    }

    /**
     * This is used for throw UserRegistrationException in case of failed registration
     *
     * @param userRegistrationException [UserRegistrationException]
     */
    @ExceptionHandler(value = UserRegistrationException.class)
    public void exception(UserRegistrationException userRegistrationException) {
        log.error("[User Registration Failed !!!! ] " + userRegistrationException);
    }


    /**
     * This is used for throw FailedToAddAssetHealthException in case of failed add asset health
     *
     * @param failedToAddAssetHealthException [FailedToAddAssetHealthException]
     */
    @ExceptionHandler(value = FailedToAddAssetHealthException.class)
    public void exception(FailedToAddAssetHealthException failedToAddAssetHealthException) {
        log.error("[Failed to add asset health !!!! ] " + failedToAddAssetHealthException);
    }

    /**
     * This is used for throw FailedToAddException in case of failed of addition
     *
     * @param failedToAddException [FailedToAddException]
     */
    @ExceptionHandler(value = FailedToAddException.class)
    public void exception(FailedToAddException failedToAddException) {
        log.error("[Failed to add !!!! ] " + failedToAddException);
    }


}
