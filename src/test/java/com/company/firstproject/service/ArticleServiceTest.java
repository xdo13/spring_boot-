package com.company.firstproject.service;

import com.company.firstproject.dto.ArticleForm;
import com.company.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {

    @Autowired //테스트할떄는 Autowired를 넣어야함
    ArticleService articleService;

    @Test
    void index() {
        // 1. 예상 데이터 - given
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        List<Article> expected = new ArrayList<>(Arrays.asList(a,b,c));
        // 2. 실제 데이터 - when
        List<Article> articles = articleService.index();
        // 3. 비교 및 검증 - then
         assertEquals(expected.toString(), articles.toString());
          //assertThat(expected.toString().equals(articles.toString()));
    }

    @Test
    void show_성공_존재하는_id_입력() {
        // 1. 예상 데이터 - given
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        // 2. 실제 데이터 - when
        Article article = articleService.show(id);
        // 3. 비교 및 검증 - then
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void show_실패_존재하지않는_id_입력() {
        // 1. 예상 데이터 - given
        Long id = -1L;
        Article expected = null;
        // 2. 실제 데이터 - when
        Article article = articleService.show(id);
        // 3. 비교 및 검증 - then
        assertEquals(expected, article);
    }

    @Test
    void create_성공_title과_content만_있는_dto_입력() {

        // 1. 예상 데이터 - given
        String title  = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);
        // 2. 실제 데이터 - when
        Article article = articleService.create(dto);

        // 3. 비교 및 검증 - then
        assertEquals(expected.toString(), article.toString());
    }
    @Test
    void create_실패_id가_포함된_dto_입력() {
        // 1. 예상 데이터 - given
        Long id = 1L;  // ID가 이미 존재하는 값
        String title  = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);  // id 포함된 DTO

        // 2. 실제 데이터 - when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            articleService.create(dto);  // ID가 포함된 DTO로 생성 시도
        });

        // 3. 비교 및 검증 - then
        String expectedMessage = "ID는 자동으로 생성되어야 합니다.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void update() {
        // 1. 예상 데이터 - given
        Long id = 1L;  // 기존에 존재하는 ID
        String updatedTitle = "업데이트된 제목";
        String updatedContent = "업데이트된 내용";
        ArticleForm dto = new ArticleForm(null, updatedTitle, updatedContent);  // id 제외한 수정용 DTO

        Article existingArticle = new Article(id, "가가가가", "1111");
        Article expected = new Article(id, updatedTitle, updatedContent);

        // 2. 실제 데이터 - when
        Article updatedArticle = articleService.update(id, dto);

        // 3. 비교 및 검증 - then
        assertEquals(expected.toString(), updatedArticle.toString());
    }
    @Test
    void delete() {
        // 1. 예상 데이터 - given
        Long id = 1L;  // 기존에 존재하는 ID
        Article existingArticle = new Article(id, "가가가가", "1111");

        // 2. 실제 데이터 - when
        Article deletedArticle = articleService.delete(id);

        // 3. 비교 및 검증 - then
        assertNotNull(deletedArticle);  // 삭제가 성공적으로 이루어졌다면 true 반환
    }
    @Test
    void delete_실패_존재하지않는_id_입력() {
        // 1. 예상 데이터 - given
        Long id = -1L;  // 존재하지 않는 ID

        // 2. 실제 데이터 - when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            articleService.delete(id);  // 존재하지 않는 ID로 삭제 시도
        });

        // 3. 비교 및 검증 - then
        String expectedMessage = "해당 ID의 글이 존재하지 않습니다.";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
}