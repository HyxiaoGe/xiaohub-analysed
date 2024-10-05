package com.xiaohub.analysed.process;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaohub.analysed.dao.entity.News;
import com.xiaohub.analysed.dto.ArticleWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ArticleItemProcessor implements ItemProcessor<ArticleWrapper, News> {

    private static final Logger logger = LoggerFactory.getLogger(ArticleItemProcessor.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public News process(ArticleWrapper wrapper) {
        try {
            String json = wrapper.getJson();
            String platform = wrapper.getPlatform();

            JsonNode jsonNode = objectMapper.readTree(json);
            String content = jsonNode.path("content").asText();
            String link = jsonNode.path("link").asText();
            String title = jsonNode.path("title").asText();
            String publicationDate = jsonNode.path("publication_date") == null?"":jsonNode.path("publication_date").asText();

            News article = new News();
            article.setContent(cleanText(content));
            article.setLink(link);
            article.setTitle(title);
            article.setPlatform(platform);
            if (!publicationDate.isBlank()) {
                article.setPublicationDate(LocalDateTime.parse(publicationDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            }

            processArticle(article);

            logger.info("Processed article: {}", article.getTitle());
            return article;
        } catch (Exception e) {
            logger.error("Error processing article for platform {}: {}", wrapper.getPlatform(), wrapper.getJson(), e);
            return null;
        }
    }

    private void processArticle(News article) {
        if (!article.getContent().equals("No content found between divs")) {
            String[] parts = article.getContent().split("总结:");
            if (parts.length > 1) {
                String keywordsSection = parts[0].trim();
                String summarySection = parts[1].trim();

                article.setKeywords(keywordsSection.replace("关键词：", "").trim());
                article.setSummary(summarySection.trim());
                article.setProcessed(true);
            }
        }
    }

    private String cleanText(String text) {
        return text.replaceAll("\\s*\\n+\\s*", " ")
                .replaceAll("\\s*<br\\s*/?\\s*>\\s*", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }

}
