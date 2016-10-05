package com.karuniko.jobs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.karuniko.service.BlankApplicationService;

/**
 * Stub of repeatable job
 *
 * @since 1.0
 */
@Component
public class SpringScheduledJob {

    private final static Logger logger = Logger.getLogger(SpringScheduledJob.class);
    
    @Autowired
    BlankApplicationService service;

    @Scheduled(cron="${scheduling.cron}")
    public void doJob(){
        logger.info("I do something useful every 5 sec. " + service.getPerson(1L).getName());
    }
}
