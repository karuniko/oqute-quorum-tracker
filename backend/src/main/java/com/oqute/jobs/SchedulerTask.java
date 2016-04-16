package com.oqute.jobs;

import java.io.Serializable;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

public interface SchedulerTask extends Serializable {
	
	public void execute(JobExecutionContext context) throws JobExecutionException, SchedulerException;

}
