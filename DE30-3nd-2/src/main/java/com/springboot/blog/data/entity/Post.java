package com.springboot.blog.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String title;
    @Column
    private String imageFiled;
    @Column(nullable = false)
    private String contents;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime modifiedAt;

}
