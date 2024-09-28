package com.xiaohub.analysed;

import com.xiaohub.analysed.service.BatchJobLauncherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
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
