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
    public BaseResponse getAllArticles() {
        List<News> articles = newsService.getAllArticles();
        return BaseResponse.ok(articles);
    }

    @GetMapping("/{id}")
    public BaseResponse getArticleById(@PathVariable Long id) {
        News article = newsService.getArticleById(id);
        if (article != null) {
            return BaseResponse.ok(article);
        } else {
            return BaseResponse.errorMsg("Article not found");
        }
    }

    @PostMapping
    public BaseResponse createArticle(@RequestBody News article) {
        News savedArticle = newsService.saveArticle(article);
        return BaseResponse.ok(savedArticle);
    }

    @PutMapping("/{id}")
    public BaseResponse updateArticle(@PathVariable Long id, @RequestBody News article) {
        News existingArticle = newsService.getArticleById(id);
        if (existingArticle != null) {
            article.setId(id);
            News updatedArticle = newsService.saveArticle(article);
            return BaseResponse.ok(updatedArticle);
        } else {
            return BaseResponse.errorMsg("Article not found");
        }
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteArticle(@PathVariable Long id) {
        News existingArticle = newsService.getArticleById(id);
        if (existingArticle != null) {
            newsService.deleteArticle(id);
            return BaseResponse.ok();
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
