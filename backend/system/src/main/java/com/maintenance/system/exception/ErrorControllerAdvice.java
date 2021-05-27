package com.maintenance.system.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This is Error advice controller
 *
 * @author Sunil, Goyal, Brijesh
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
        log.error("[AllAssetDetails] [getAllAssets] " + noSuchAssetFoundException);
    }

    /**
     * This is used for throw MismatchedPasswordException in case of incorrect password
     *
     * @param mismatchedPasswordException this will throw MismatchedPasswordException
     */
    @ExceptionHandler(value = MismatchedPasswordException.class)
    public void exception(MismatchedPasswordException mismatchedPasswordException) {
        log.error("[MismatchedPasswordException] " + mismatchedPasswordException);
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

}
