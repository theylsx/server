package com.gowithu.springboot.dao.impl.mongodb;

import com.gowithu.springboot.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PostTemplateImpl implements com.gowithu.springboot.dao.PostTemplate {
    @Autowired private MongoTemplate mongoTemplate;

    @Override
    public void save(Post post){
        mongoTemplate.save(post);
    }

    @Override
    public Post findById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Post.class);
    }

    @Override
    public Post findByStringId(String stringId){
        Query query = new Query(Criteria.where("stringId").is(stringId));
        return mongoTemplate.findOne(query, Post.class);
    }

    @Override
    public List<Post> findAll() {
        System.out.println(mongoTemplate.findAll(Post.class).size());
        return mongoTemplate.findAll(Post.class);
    }

    @Override
    public Post findLatestByPublisherId(String openId){
        Query query = new Query(Criteria.where("publisherId").is(openId));
        List<Post> result = mongoTemplate.find(query, Post.class);
        return result.get(result.size() - 1);
    }
}
