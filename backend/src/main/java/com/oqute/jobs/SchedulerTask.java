package com.oqute.jobs;

import java.io.Serializable;

import org.quartz.JobExecutionContext;

public interface SchedulerTask extends Serializable {
	
	public void execute(JobExecutionContext context);

}
