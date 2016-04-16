package com.oqute.jobs;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.oqute.service.OQuteApplicationService;

public class SchedulerTaskImpl implements SchedulerTask {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Logger logger = Logger.getLogger(SchedulerTaskImpl.class);
	
	@Autowired
	private transient OQuteApplicationService service;

	@Override
	public void execute(JobExecutionContext context) {
		logger.info("executing spring service from custom job: " +service.getPerson().getName());
	}

}
