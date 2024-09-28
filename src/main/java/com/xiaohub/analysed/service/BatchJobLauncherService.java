package com.xiaohub.analysed.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BatchJobLauncherService {

    private static final Logger logger = LoggerFactory.getLogger(BatchJobLauncherService.class);

    private final JobLauncher jobLauncher;
    private final Job processArticleJob;

    @Autowired
    public BatchJobLauncherService(JobLauncher jobLauncher, Job processArticleJob) {
        this.jobLauncher = jobLauncher;
        this.processArticleJob = processArticleJob;
    }

    public void launchBatchJob() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        jobLauncher.run(processArticleJob, jobParameters);
    }

}