package com.springboot.blog.data.repository;

import com.springboot.blog.data.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByUserId(Long userId);
    List<Profile> findByProfileContents(String profileContents);
    List<Profile> findAllByOrderByModifiedAtDesc();
}
