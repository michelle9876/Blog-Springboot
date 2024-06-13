package com.springboot.blog.service;

import com.springboot.blog.data.dto.UserRequestDto;
import com.springboot.blog.data.entity.User;

public interface UserService {
    User createUser(UserRequestDto userRequestDto);

    User findById(Long userId);

    User updateById(Long userId, UserRequestDto userRequestDto);

    void deleteById(Long userId);
}
