package com.xiaohub.analysed.service;

import com.xiaohub.analysed.dao.entity.News;
import com.xiaohub.analysed.dao.repo.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> getAllArticles() {
        return newsRepository.findAll();
    }

    public News getArticleById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }

    public News saveArticle(News article) {
        return newsRepository.save(article);
    }

    public void deleteArticle(Long id) {
        newsRepository.deleteById(id);
    }

    public List<News> getLatestArticles() {
        return newsRepository.findTop10ByOrderByPublicationDateDesc();
    }

    public List<News> getUnprocessedArticles() {
        return newsRepository.findByIsProcessedFalse();
    }

}
