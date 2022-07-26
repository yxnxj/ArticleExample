package com.example.article.article;

import com.example.article.article.dto.ArticleDto;

import java.util.List;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public long write(String title, String body) {
        return articleRepository.write(title, body);
    }

    public List<ArticleDto> findAll() {
        return articleRepository.findAll();
    }
}