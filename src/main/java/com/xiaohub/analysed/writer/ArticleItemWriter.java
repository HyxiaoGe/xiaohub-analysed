package com.xiaohub.analysed.writer;

import com.xiaohub.analysed.dao.entity.News;
import com.xiaohub.analysed.dao.repo.NewsRepository;
import com.xiaohub.analysed.process.ArticleItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleItemWriter implements ItemWriter<News> {

    private static final Logger logger = LoggerFactory.getLogger(ArticleItemProcessor.class);

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void write(List<? extends News> articles) {
        newsRepository.saveAll(articles);
        logger.info("Saved {} articles", articles.size());
    }
}
