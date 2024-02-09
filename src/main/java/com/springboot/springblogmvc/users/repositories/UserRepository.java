package com.springboot.springblogmvc.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.springblogmvc.users.entities.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query(value = "select * from users where name =?1", nativeQuery = true)
    User findUserByName(String name);
}
