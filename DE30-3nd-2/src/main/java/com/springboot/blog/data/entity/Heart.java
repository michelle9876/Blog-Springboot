package com.springboot.blog.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
public class Heart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long heartId;
    @Column(nullable = false)
    private long postId;
    @Column(nullable = false)
    private long userId;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime modifiedAt;
}
