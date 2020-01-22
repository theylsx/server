package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * @author david
 */
@Component
public class UserTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    public User findByOpenId(String openId){
        Query query = new Query(Criteria.where("openId").is(openId));
        return mongoTemplate.findOne(query, User.class);
    }

    public void save(User user){
       mongoTemplate.save(user);
    }
}
