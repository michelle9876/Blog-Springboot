package com.springboot.blog.service.impl;

import com.springboot.blog.data.entity.Profile;
import com.springboot.blog.data.repository.ProfileRepository;
import com.springboot.blog.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile getProfileByUserId(Long userId) {
        return profileRepository.findByUserId(userId).orElse(null);
    }

    @Override
    public void saveProfile(Profile profile) {
        profile.setModifiedAt(LocalDateTime.now());
        // 기존 프로필 모두 삭제
        profileRepository.deleteAll();
        // 새로운 프로필 생성
        profileRepository.save(profile);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAllByOrderByModifiedAtDesc();
    }
}
