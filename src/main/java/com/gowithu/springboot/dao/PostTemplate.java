package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class PostTemplate {
    @Autowired private MongoTemplate mongoTemplate;

    public void save(Post post){
        mongoTemplate.save(post);
    }

    public Post findById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Post.class);
    }

    public Post findByStringId(String stringId){
        Query query = new Query(Criteria.where("stringId").is(stringId));
        return mongoTemplate.findOne(query, Post.class);
    }

    public List<Post> findAll() {
        return mongoTemplate.findAll(Post.class);
    }

    public Post findLatestByPublisherId(String openId){
        Query query = new Query(Criteria.where("publisherId").is(openId));
        List<Post> result = mongoTemplate.find(query, Post.class);
        return result.get(result.size() - 1);
    }
}
