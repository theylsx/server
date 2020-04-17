package com.gowithu.springboot.dao.impl.mongodb;

import com.gowithu.springboot.entity.Feedback;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FeedbackTemplateImpl implements com.gowithu.springboot.dao.FeedbackTemplate {
    @Autowired private MongoTemplate mongoTemplate;

    @Override
    public Feedback findById(ObjectId id){
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Feedback.class);
    }

    @Override
    public Feedback findByTitle(String title){
        Query query = new Query(Criteria.where("title").is(title));
        return mongoTemplate.findOne(query, Feedback.class);
    }

    @Override
    public List<Feedback> findByStudentOpenId(String openId){
        Query query = new Query(Criteria.where("studentOpenId").is(openId));
        return mongoTemplate.find(query, Feedback.class);
    }



    @Override
    public void save(Feedback feedback){
        mongoTemplate.save(feedback);
    }


}
