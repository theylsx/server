package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Post;

import java.util.List;

public interface PostTemplate {
    void save(Post post);

    Post findById(Integer id);

    Post findByStringId(String stringId);

    List<Post> findAll();

    Post findLatestByPublisherId(String openId);
}
