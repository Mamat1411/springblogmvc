package com.springboot.springblogmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springblogmvc.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
