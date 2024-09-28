package com.xiaohub.analysed.writer;

import com.xiaohub.analysed.dao.entity.RawArticle;
import com.xiaohub.analysed.dao.repo.RawArticleRepository;
import com.xiaohub.analysed.process.ArticleItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleItemWriter implements ItemWriter<RawArticle> {

    private static final Logger logger = LoggerFactory.getLogger(ArticleItemProcessor.class);

    @Autowired
    private RawArticleRepository rawArticleRepository;

    @Override
    public void write(List<? extends RawArticle> articles) {
        rawArticleRepository.saveAll(articles);
        logger.info("Saved {} articles", articles.size());
    }
}
