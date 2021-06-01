package com.maintenance.system.util;

import com.maintenance.system.exception.AssetHealthPropNotFoundException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * This class will provide the custom functions
 *
 * @author Gordhan Goyal
 */
@Slf4j
public class CustomFunctions {


    /**
     * This method generates the random health for asset example- asset id, velocity, pressure
     *
     * @param min [Integer] takes the minimum number
     * @param max [Integer] takes the maximum number
     * @return returns the random integer
     */
    public static int random(@NonNull int min, @NonNull int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /**
     * This method returns the current date and time in yyyy-MM-dd HH:mm:ss format
     *
     * @return return the object of java.util.Date
     */
    public static Date currentDateTime() {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(df.format(Calendar.getInstance().getTime()));
        } catch (ParseException e) {
            log.error("[AssetHealthGenerator] [currentDateTime] " + e);
        }
        return new Date();
    }

    /**
     * This method used for the get value from the key
     *
     * @param map [Map<String,Integer>]
     * @param key takes key from map
     * @return returns the Integer value of provided key
     */
    public Integer propValue(@NonNull Map<String, Integer> map, @NonNull String key) {
        return map.get(key);
    }

    /**
     * This method used for read the properties file
     *
     * @param fileName [String] name of the property file
     * @return returns the [Map<String,Integer>] from the property file
     */
    public Map<String, Integer> readProp(@NonNull String fileName) {
        Map<String, Integer> map = new HashMap<>();
        InputStream inputStream;
        try {
            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new AssetHealthPropNotFoundException();
            }

            for (String key : prop.stringPropertyNames()) {
                String value = prop.getProperty(key.trim());
                map.put(key, Integer.valueOf(value.trim()));
            }

            inputStream.close();

        } catch (IOException exception) {
            log.error("[readProp] " + exception);
        }
        return map;
    }

    /**
     * This method used to validate the email format
     *
     * @param email [String] email
     * @return returns boolean, true in case of valid email format or else false
     */
    public static boolean isValidEmail(@NonNull String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
}
