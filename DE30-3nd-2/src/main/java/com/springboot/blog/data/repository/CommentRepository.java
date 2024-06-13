package com.springboot.blog.data.repository;

import com.springboot.blog.data.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
