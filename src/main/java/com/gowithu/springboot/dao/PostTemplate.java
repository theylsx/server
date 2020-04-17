package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Post;

import org.bson.types.ObjectId;

import java.util.List;

public interface PostTemplate {
    void save(Post post);

    Post findById(ObjectId id);


    List<Post> findAll();

    Post findLatestByPublisherId(String openId);
}
