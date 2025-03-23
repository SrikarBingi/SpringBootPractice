package com.gfg.first;

import org.apache.commons.logging.LogFactory;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController
public class LogDemo {
    private org.apache.commons.logging.Log logger = LogFactory.getLog(LogDemo.class);

    @GetMapping("/log")
    public void printLog(){
        //insert a record in db
        //make an api call
        logger.info("information  is printed ");
        logger.warn("warning   is printed ");
        logger.error("error is printed ");
        logger.trace("trace is printed ");
        // logger.(inner_expression${})
    }
}
