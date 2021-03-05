package com.bzdgn.camel.application;

import static com.bzdgn.camel.application.Constants.ENDPOINT_HEALTH;
import static com.bzdgn.camel.application.Constants.ENDPOINT_HEALTH_DEFAULT;
import static com.bzdgn.camel.application.Constants.SOURCE_ENDPOINT;
import static com.bzdgn.camel.application.Constants.SOURCE_ENDPOINT_DEFAULT;
import static com.bzdgn.camel.application.Constants.DELAY_SEC;
import static com.bzdgn.camel.application.Constants.DELAY_SEC_DEFAULT;
import static com.bzdgn.camel.application.Constants.REPEAT_INTERVAL;
import static com.bzdgn.camel.application.Constants.REPEAT_INTERVAL_DEFAULT;
import static com.bzdgn.camel.application.util.GenUtil.getEnv;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bzdgn.camel.application.route.HealthRoute;
import com.bzdgn.camel.application.route.PollRoute;

public class EntryPoint {

    public static final Logger LOGGER = LoggerFactory.getLogger(EntryPoint.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("camel-web-service-poll-to-broker v0.1 started");
        
        Main main = new Main();
        
        Properties props = new Properties();
        main.bind("properties", createProperties(props));
        
        main.addRouteBuilder(new HealthRoute());
        main.addRouteBuilder(new PollRoute());
        
        logProperties(props);
        
        main.run();
    }
    
    public static PropertiesComponent createProperties(Properties source) {
        PropertiesComponent pc = new PropertiesComponent();
        
        source.put(ENDPOINT_HEALTH, getEnv(ENDPOINT_HEALTH, ENDPOINT_HEALTH_DEFAULT));
        source.put(SOURCE_ENDPOINT, getEnv(SOURCE_ENDPOINT, SOURCE_ENDPOINT_DEFAULT));
        source.put(DELAY_SEC, getEnv(DELAY_SEC, DELAY_SEC_DEFAULT));
        source.put(REPEAT_INTERVAL, getEnv(REPEAT_INTERVAL, REPEAT_INTERVAL_DEFAULT));
        
        pc.setInitialProperties(source);
        
        return pc;
    }
    
    private static void logProperties(Properties source) {
        Set<Object> keys = new HashSet<>(source.keySet());
        
        LOGGER.info("Printing Environmental Variables");
        LOGGER.info("********************************");
        for (Object key: keys) {
            LOGGER.info("{}={}", key, source.get(key));
        }
        LOGGER.info("********************************");
    }
    
}
