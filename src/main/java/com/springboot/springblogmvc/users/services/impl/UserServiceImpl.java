package com.springboot.springblogmvc.users.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.springblogmvc.users.entities.User;
import com.springboot.springblogmvc.users.repositories.UserRepository;
import com.springboot.springblogmvc.users.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public User saveUser(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String name) {
        User user = userRepository.findUserByName(name);
        userRepository.deleteById(user.getId());
    }
    
}
