package com.springboot.blog.data.dao.impl;

import com.springboot.blog.data.dao.UserDao;
import com.springboot.blog.data.dto.UserRequestDto;
import com.springboot.blog.data.entity.User;
import com.springboot.blog.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@RequiredArgsConstructor

public class UserDaoImpl implements UserDao {
    private final UserRepository userRepository;

   @Override
    public User createUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public User findByUserId(Long userId) throws Exception{
        Optional<User> foundUser = userRepository.findById(userId);
        if (foundUser.isPresent()){
            return foundUser.get();
        }else{
            throw new Exception("회원정보가 존재하지 않습니다.");
        }
    }

    @Override
    public User updateByUserId(Long userId, UserRequestDto userRequestDto) throws Exception {
       User foundUser = findByUserId(userId);
       foundUser.setName(userRequestDto.getName());
       foundUser.setEmail(userRequestDto.getEmail());
       foundUser.setPassword(userRequestDto.getPassword());
       foundUser.setRePassword(userRequestDto.getRePassword());
       return userRepository.save(foundUser);
    }

    @Override
    public void deleteByUserId(Long userId) throws Exception {
        User foundUser = findByUserId(userId);
        userRepository.delete(foundUser);
    }


}
