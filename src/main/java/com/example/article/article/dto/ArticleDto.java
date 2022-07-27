package com.example.article.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
public class ArticleDto {
    private long id;
    private String title;
    private String body;

}
