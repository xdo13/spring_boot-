INSERT INTO article(id, title, content) VALUES(1, '가가가가', '11111');
INSERT INTO article(id, title, content) VALUES(2, '나나나나', '22222');
INSERT INTO article(id, title, content) VALUES(3, '다다다다', '33333');

SELECT * FROM article;

----------------------------------
-- 기존 데이터
INSERT INTO ARTICLE (TITLE, CONTENT) VALUES ('가가가가', '1111');
INSERT INTO ARTICLE (TITLE, CONTENT) VALUES ('나나나나', '2222');
INSERT INTO ARTICLE (TITLE, CONTENT) VALUES ('다다다다', '3333');

-- ① article 테이블에 데이터 추가
INSERT INTO article(title, content) VALUES ('당신의 인생 영화는?', '댓글 고');
INSERT INTO article(title, content) VALUES('당신의 소울 푸드는?', '댓글 고고');
INSERT INTO article(title, content) VALUES ('당신의 취미는?', '댓글 고고고');

-- ② 4번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Park', '굿 윌 헌팅');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Kim', '아이 엠 샘');
INSERT INTO comment(article_id, nickname, body) VALUES (4, 'Choi', '쇼생크 탈출');

-- ③ 5번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Park', '치킨');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Kim', '샤브샤브');
INSERT INTO comment(article_id, nickname, body) VALUES (5, 'Choi', '초밥');

-- ④ 6번 게시글의 댓글 추가
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Park', '조깅');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Kim', '유튜브 시청');
INSERT INTO comment(article_id, nickname, body) VALUES (6, 'Choi', '독서');