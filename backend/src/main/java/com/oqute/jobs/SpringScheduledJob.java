package com.oqute.jobs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.oqute.service.OQuteApplicationService;

/**
 * Stub of repeatable job
 *
 * @since 1.0
 */
@Component
public class SpringScheduledJob {

    private final static Logger logger = Logger.getLogger(SpringScheduledJob.class);
    
    @Autowired
    OQuteApplicationService service;

    @Scheduled(fixedDelay = 5000)
    public void doJob(){
        logger.info("I do something useful every 5 sec. " + service.getPerson().getName());
    }
}
