package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Feedback;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FeedbackTemplate {
    @Autowired private MongoTemplate mongoTemplate;

    public Feedback findById(ObjectId id){
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Feedback.class);
    }

    public Feedback findByTitle(String title){
        Query query = new Query(Criteria.where("title").is(title));
        return mongoTemplate.findOne(query, Feedback.class);
    }

    public List<Feedback> findByStudentOpenId(String openId){
        Query query = new Query(Criteria.where("studentOpenId").is(openId));
        return mongoTemplate.find(query, Feedback.class);
    }



    public void save(Feedback feedback){
        mongoTemplate.save(feedback);
    }


}
