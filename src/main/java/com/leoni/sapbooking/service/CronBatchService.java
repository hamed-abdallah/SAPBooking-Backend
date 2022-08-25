package com.leoni.sapbooking.service;

import javax.batch.operations.JobRestartException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.SneakyThrows;
@Service
public class CronBatchService {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;

	
	@SneakyThrows
	@Scheduled(cron="0/15 * * * * ?")
	public void StarterJob() {
		JobParameters jobParameter = new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis()).toJobParameters();
		
			try {
				jobLauncher.run(job, jobParameter);
			} catch (JobExecutionAlreadyRunningException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (org.springframework.batch.core.repository.JobRestartException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobInstanceAlreadyCompleteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobParametersInvalidException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		System.out.println("Starter Batch ...");
				
	}

}
