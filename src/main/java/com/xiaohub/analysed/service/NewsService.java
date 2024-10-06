package com.xiaohub.analysed.service;

import com.xiaohub.analysed.dao.entity.News;
import com.xiaohub.analysed.dao.repo.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News getArticleById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    public List<News> getLatestArticles() {
        return newsRepository.findLatestByPlatform();
    }

    public List<News> findAISummarizedNews() {
        Pageable pageable = PageRequest.of(0, 10);
        return newsRepository.findAISummarizedNews(pageable);
    }

    public List<News> getUnprocessedArticles() {
        return newsRepository.findByIsProcessedFalse();
    }

}
