package com.xiaohub.analysed.controller;

import com.xiaohub.analysed.base.BaseResponse;
import com.xiaohub.analysed.dao.entity.News;
import com.xiaohub.analysed.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/news")
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public BaseResponse getNews() {
        List<News> news = newsService.getLatestArticles();
        return BaseResponse.ok(news);
    }

    @GetMapping("/ai-summary")
    public BaseResponse getNewsByAISummary() {
        List<News> news = newsService.findAISummarizedNews();
        return BaseResponse.ok(news);
    }

    @GetMapping("/{id}")
    public BaseResponse getNewsById(@PathVariable Long id) {
        News article = newsService.getArticleById(id);
        if (article != null) {
            return BaseResponse.ok(article);
        } else {
            return BaseResponse.errorMsg("Article not found");
        }
    }

    @GetMapping("/unprocessed")
    public BaseResponse getUnprocessedArticles() {
        List<News> unprocessedArticles = newsService.getUnprocessedArticles();
        return BaseResponse.ok(unprocessedArticles);
    }

}
