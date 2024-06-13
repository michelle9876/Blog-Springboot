package com.springboot.blog.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@ToString
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String projectTitle;
    @Column
    private LocalDateTime projectDate;
    @Column(nullable = false)
    private String imageFiled;
    @Column
    private String contents;
    @Column
    private String urlLink;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime modifiedAt;
}
