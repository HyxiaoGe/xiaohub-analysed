package com.xiaohub.analysed;

import com.xiaohub.analysed.service.BatchJobLauncherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "spring.batch.job.enabled", havingValue = "true", matchIfMissing = false)
public class BatchJobRunner implements CommandLineRunner {

    private final BatchJobLauncherService batchJobLauncherService;

    @Autowired
    public BatchJobRunner(BatchJobLauncherService batchJobLauncherService) {
        this.batchJobLauncherService = batchJobLauncherService;
    }

    @Override
    public void run(String... args) throws Exception {
        batchJobLauncherService.launchBatchJob();
    }
}
