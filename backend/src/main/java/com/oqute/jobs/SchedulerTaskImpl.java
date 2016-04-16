package com.oqute.jobs;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

public class SchedulerTaskImpl implements SchedulerTask {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Logger logger = Logger.getLogger(SchedulerTaskImpl.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException, SchedulerException {
		logger.info("executing spring service from custom job");
	}

}
