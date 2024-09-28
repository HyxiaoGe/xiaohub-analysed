package com.xiaohub.analysed.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisBatchProcessingService {

    private static final Logger logger = LoggerFactory.getLogger(RedisBatchProcessingService.class);

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job processRawArticle;

    private void processBatchFromRedis() {
        logger.info("Starting batch processing articles from Redis");
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();
            JobExecution jobExecution = jobLauncher.run(processRawArticle, jobParameters);
            logger.info("Job finished with status: {}", jobExecution.getStatus());
        } catch (Exception e) {
            logger.error("Error during batch processing", e);
        }
    }
}
