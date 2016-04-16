package com.oqute.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.oqute.service.OQuteApplicationService;

public class ScheduledJob extends QuartzJobBean {
	
	private SchedulerTask schedulerTask;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		if (schedulerTask != null)
			try {
				schedulerTask.execute(context);
			} catch (SchedulerException e) {
				throw new JobExecutionException(e);
			}
	}
	
	public void setSchedulerTask(SchedulerTask schedulerTask) {
        this.schedulerTask = schedulerTask;
    }

}
