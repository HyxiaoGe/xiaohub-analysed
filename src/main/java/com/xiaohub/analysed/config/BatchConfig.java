package com.xiaohub.analysed.config;

import com.xiaohub.analysed.dao.entity.News;
import com.xiaohub.analysed.dto.ArticleWrapper;
import com.xiaohub.analysed.process.ArticleItemProcessor;
import com.xiaohub.analysed.reader.RedisItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing(modular=true)
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private RedisItemReader redisItemReader;

    @Autowired
    private ArticleItemProcessor articleItemProcessor;

    @Autowired
    private ItemWriter<News> articleItemWriter;

    @Bean
    public Job processArticlesJob(Step processArticlesStep) {
        return jobBuilderFactory.get("processArticlesJob")
                .incrementer(new RunIdIncrementer())
                .flow(processArticlesStep)
                .end()
                .build();
    }

    @Bean
    public Step processArticlesStep(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("processArticlesStep")
                .<ArticleWrapper, News>chunk(10)
                .reader(redisItemReader)
                .processor(articleItemProcessor)
                .writer(articleItemWriter)
                .build();
    }

}
