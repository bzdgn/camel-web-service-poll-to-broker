package com.bzdgn.camel.application.process;

import static com.bzdgn.camel.application.util.GenUtil.getCount;
import static com.bzdgn.camel.application.Constants.ID_PROPERTY;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CounterProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.setProperty(ID_PROPERTY, getCount());
    }

}
