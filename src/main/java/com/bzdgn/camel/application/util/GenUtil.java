package com.bzdgn.camel.application.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenUtil {
    
    public static final Logger LOGGER = LoggerFactory.getLogger(GenUtil.class);
    private static int counter = 1;

    public static String getEnv(String key, String defaultValue) {
        String value = System.getenv(key);
        if (value == null) {
            LOGGER.warn("Environment variabele \"{}\" is niet gezet, default waarde ingesteld", key);
            return defaultValue;
        } else {
            return value;
        }
    }

    public static String getEnv(String key) {
        if (System.getenv(key) != null) {
            return System.getenv(key);
        } else {
            throw new Error("Environment variabele \"" + key + "\" is niet gezet.");
        }
    }
    
    public static int getCount() {
        return counter++;
    }
}
