package com.company.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne // Comment 엔티티와 Article 엔티티를 다대일 관계롤 설정
    @JoinColumn(name="article_id") // 외래키 설정, Article 엔티티의 기본키(id)와 매핑
    private Article article; //해당 댓글의 부모 게시글
    private String nickname;
    private String body;
}
