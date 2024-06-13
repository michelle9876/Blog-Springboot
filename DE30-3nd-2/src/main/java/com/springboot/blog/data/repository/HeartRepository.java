package com.springboot.blog.data.repository;

import com.springboot.blog.data.entity.Heart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeartRepository extends JpaRepository<Heart, Long> {
}
