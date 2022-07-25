package com.example.article.article;

import com.example.article.Rq;
import com.example.article.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    public void showList(Rq rq){
        List<ArticleDto> articleDtos = new ArrayList<>();
        articleDtos.add(new ArticleDto(3, "title 3", "body 3"));
        articleDtos.add(new ArticleDto(2, "title 2", "body 2"));
        articleDtos.add(new ArticleDto(1, "title 1", "body 1"));

        rq.setAttr("articleDtos", articleDtos);

        rq.view("usr/article/list");
    }

    public void showWrite(Rq rq) {
        rq.view("usr/article/write");
    }
}
