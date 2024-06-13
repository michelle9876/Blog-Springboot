package com.springboot.blog.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@Entity
public class AttachedFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long postId;
    @Column(nullable = false)
    private long projectId;
    @Column(nullable = false)
    private String fileName;
    @Column(nullable = false)
    private int fileType;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime modifiedAt;
}
