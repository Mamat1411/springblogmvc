package com.springboot.springblogmvc.users.services;

import java.util.List;

import com.springboot.springblogmvc.users.entities.User;

public interface UserService {
    List<User> getAllUser();
    User getUserByName(String name);
    User saveUser(User user);
    void deleteUser(String name);
}
