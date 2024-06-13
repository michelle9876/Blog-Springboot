package com.springboot.blog.data.dao;

import com.springboot.blog.data.dto.UserRequestDto;
import com.springboot.blog.data.entity.User;

public interface UserDao {
    User createUser(User user);
    User findByUserId(Long userId)  throws Exception;

    User updateByUserId(Long userId, UserRequestDto userRequestDto) throws Exception;

    void deleteByUserId(Long userId) throws  Exception;
}
