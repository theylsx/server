package com.gowithu.springboot.dao.impl.mongodb;

import com.gowithu.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author david
 */
@Repository
public class UserTemplateImpl implements com.gowithu.springboot.dao.UserTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public User findByOpenId(String openId){
        Query query = new Query(Criteria.where("openId").is(openId));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public void save(User user){
       mongoTemplate.save(user);
    }

}
