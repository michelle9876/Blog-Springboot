package com.springboot.blog.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long profileId;
    @Column(nullable = false)
    private long userId;
    @Lob
    private byte[] imageFiled;
    @Column(nullable = false)
    private String profileContents;
    @Column
    private String techStack;
    @Column
    private String experiences;
    @Column
    private String urlLink;
    @Column
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column
    private LocalDateTime modifiedAt = LocalDateTime.now();
}
