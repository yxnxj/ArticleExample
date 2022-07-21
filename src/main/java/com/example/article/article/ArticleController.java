package com.example.article.article;

import com.example.article.Rq;

public class ArticleController {
    public void showList(Rq rq){
        rq.appendBody("게시물 리스트");
    }
}
