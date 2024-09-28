package com.xiaohub.analysed.reader;

import com.xiaohub.analysed.dto.ArticleWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class RedisItemReader implements ItemReader<ArticleWrapper> {

    private static final Logger logger = LoggerFactory.getLogger(RedisItemReader.class);
    private static final String ARTICLES_KEY_PREFIX = "articles_by_platform:";
    private static final List<String> PLATFORM_LIST = List.of("zaobao", "oeeee", "chlinlearn", "deeplearning", "36kr");

    private String currentPlatform;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    private Iterator<String> articleIterator;
    private Iterator<String> platformIterator;

    @Override
    public ArticleWrapper read() throws Exception {
        if (articleIterator == null || !articleIterator.hasNext()) {
            if (platformIterator == null) {
                platformIterator = PLATFORM_LIST.iterator();
            }
            if (platformIterator.hasNext()) {
                currentPlatform = platformIterator.next();
                String redisKey = ARTICLES_KEY_PREFIX + currentPlatform;
                List<String> articles = redisTemplate.opsForList().range(redisKey, 0, -1);
                articleIterator = articles.iterator();
                logger.info("Reading articles for platform: {}, count: {}", currentPlatform, articles.size());
            } else {
                return null; // No more platforms to process
            }
        }
        String json = articleIterator.hasNext() ? articleIterator.next() : null;
        if (json != null) {
            return new ArticleWrapper(json, currentPlatform);
        }
        return null;
    }

}
