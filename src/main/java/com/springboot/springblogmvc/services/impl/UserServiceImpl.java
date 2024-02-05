package com.springboot.springblogmvc.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springblogmvc.entities.User;
import com.springboot.springblogmvc.repositories.UserRepository;
import com.springboot.springblogmvc.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
    
}
