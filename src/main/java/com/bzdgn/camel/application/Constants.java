package com.bzdgn.camel.application;

public class Constants {
    
    public static final String POLL_ROUTE_ID            = "poll-route";
    public static final String QUARTZ_WEB_SERVICE       = "quartz2://QUARTZ_WEB_SERVICE?startDelayedSeconds={{DELAY_SEC}}&trigger.repeatCount=-1&trigger.repeatInterval={{REPEAT_INTERVAL}}";
    
    // env
    public static final String ENDPOINT_HEALTH          = "ENDPOINT_HEALTH";
    public static final String ENDPOINT_HEALTH_DEFAULT  = "http://0.0.0.0:8081";
    public static final String SOURCE_ENDPOINT          = "SOURCE_ENDPOINT";
    public static final String SOURCE_ENDPOINT_DEFAULT  = "http://localhost:8080/person/";
    public static final String DELAY_SEC                = "DELAY_SEC";
    public static final String DELAY_SEC_DEFAULT        = "5";
    public static final String REPEAT_INTERVAL          = "REPEAT_INTERVAL";
    public static final String REPEAT_INTERVAL_DEFAULT  = "5000";
    
    // properties
    public static final String ID_PROPERTY              = "ID_PROPERTY";
    
}
