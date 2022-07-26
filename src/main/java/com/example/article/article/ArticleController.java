package com.example.article.article;

import com.example.article.Rq;
import com.example.article.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    private ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void showList(Rq rq){
        List<ArticleDto> articleDtos = articleService.findAll();
//        articleDtos.add(new ArticleDto(3, "title 3", "body 3"));
//        articleDtos.add(new ArticleDto(2, "title 2", "body 2"));
//        articleDtos.add(new ArticleDto(1, "title 1", "body 1"));

        rq.setAttr("articleDtos", articleDtos);

        rq.view("usr/article/list");
    }

    public void showWrite(Rq rq) {
        rq.view("usr/article/write");
    }

    public void doWrite(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");

        long id = articleService.write(title, body);

        rq.appendBody("%d번 게시물이 생성 되었습니다.".formatted(id));
    }


    public void showDetail(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);

        if (id == 0) {
            rq.appendBody("번호를 입력해주세요.");
            return;
        }

        ArticleDto articleDto = articleService.findById(id);

        if (articleDto == null) {
            rq.appendBody("해당 글이 존재하지 않습니다.");
            return;
        }

        rq.setAttr("article", articleDto);
        rq.view("usr/article/detail");
    }
}
