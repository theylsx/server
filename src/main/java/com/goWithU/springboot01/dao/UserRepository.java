package com.goWithU.springboot01.dao;

import com.goWithU.springboot01.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByopenId(String openId);
}
