package com.bzdgn.camel.application.route;

import static com.bzdgn.camel.application.Constants.QUARTZ_WEB_SERVICE;
import static com.bzdgn.camel.application.Constants.POLL_ROUTE_ID;
import static com.bzdgn.camel.application.Constants.ID_PROPERTY;

import java.net.ConnectException;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import com.bzdgn.camel.application.process.CounterProcessor;

public class PollRoute extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {
        
        onException(ConnectException.class)
            .log(LoggingLevel.ERROR, "Cannot poll from {{SOURCE_ENDPOINT}}")
            .handled(true);
        
        from(QUARTZ_WEB_SERVICE)
            .routeId(POLL_ROUTE_ID)
            .startupOrder(1)
            .process(new CounterProcessor())
            .toD("{{SOURCE_ENDPOINT}}${exchangeProperty[" + ID_PROPERTY + "]}")
            .convertBodyTo(String.class)
            .log("${body}");
        
    }

}
