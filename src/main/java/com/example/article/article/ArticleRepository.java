package com.example.article.article;


import com.example.article.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private static List<ArticleDto> datum;
    private static long lastId;

    static {
        datum = new ArrayList<>();
        lastId = 0;
    }

    public long write(String title, String body) {
        long id = ++lastId;
        ArticleDto newArticleDto = new ArticleDto(id, title, body);

        datum.add(newArticleDto);

        return id;
    }

    public List<ArticleDto> findAll() {
        return datum;
    }

    public ArticleDto findById(long id) {
        for ( ArticleDto articleDto : datum ) {
            if ( articleDto.getId() == id ) {
                return articleDto;
            }
        }
        return null;
    }

    public void delete(long id) {
        ArticleDto article = findById(id);

        datum.remove(article);
    }

    public void modify(long id, String title, String body) {
        int index = -1;
        ArticleDto article = new ArticleDto(id, title, body);
        for(int i = 0; i< datum.size(); i++){
            if(id == datum.get(i).getId()){
                index = i;
                break;
            }
        }
        if(index == -1) return;

        datum.set(index, article);
    }
}