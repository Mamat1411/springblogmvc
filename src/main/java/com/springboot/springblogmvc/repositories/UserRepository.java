package com.springboot.springblogmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.springblogmvc.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
