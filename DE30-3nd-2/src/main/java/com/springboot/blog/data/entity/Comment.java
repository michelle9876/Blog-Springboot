package com.springboot.blog.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    @Column(nullable = false)
    private Long postId;
    @Column(nullable = false)
    private Long userId;
    @Column
    private String contents;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime modifiedAt;
}
