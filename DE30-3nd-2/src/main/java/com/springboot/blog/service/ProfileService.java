package com.springboot.blog.service;

import com.springboot.blog.data.entity.Profile;
import java.util.List;

public interface ProfileService {
    List<Profile> getAllProfiles();

    Profile getProfileByUserId(Long userId);

    void saveProfile(Profile profile);
}
