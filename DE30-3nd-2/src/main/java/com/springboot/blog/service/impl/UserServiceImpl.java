package com.springboot.blog.service.impl;

import com.springboot.blog.data.dao.UserDao;
import com.springboot.blog.data.dto.UserRequestDto;
import com.springboot.blog.data.entity.User;
import com.springboot.blog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User createUser(UserRequestDto userRequestDto){
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
//    일반 패스워드를 암호화 해서 전달
        String encodedPassword = bCryptPasswordEncoder.encode(userRequestDto.getPassword());
        String encodedRePassword = bCryptPasswordEncoder.encode(userRequestDto.getRePassword());
        user.setPassword(encodedPassword);
        user.setRePassword(encodedRePassword);
        return userDao.createUser(user);
    }

    @Override
    public User findById(Long userId){
        User user =null;
        try{
            user = userDao.findByUserId(userId);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public User updateById(Long userId, UserRequestDto userRequestDto){
        User user = null;
        try{
            user = userDao.updateByUserId(userId, userRequestDto);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public void deleteById(Long userId){
        try{
            userDao.deleteByUserId(userId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}


