package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.User;

public interface UserTemplate {
    User findByOpenId(String openId);

    void save(User user);
}
