package com.springboot.blog.data.repository;

import com.springboot.blog.data.entity.AttachedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttatchedFileRepository extends JpaRepository <AttachedFile, Long > {
}
