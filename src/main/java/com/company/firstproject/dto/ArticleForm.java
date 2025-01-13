package com.company.firstproject.dto;

import com.company.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@AllArgsConstructor

@Getter
@Setter
@ToString

public class ArticleForm {
    private Long id;
    private String title;
    private String content;


    public Article toNoIdEntity() {
        return new Article(null, title, content);
    }

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
