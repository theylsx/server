package com.gowithu.springboot.dao.impl.mongodb;

import com.gowithu.springboot.entity.Answer;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
 * @author dav1d
 */
@Repository
public class AnswerTemplateImpl implements com.gowithu.springboot.dao.AnswerTemplate {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Answer findByOpenIdAndWorkId(String openId, ObjectId workId){
        Query query = new Query(Criteria.where("studentId").is(openId).and("workId").is(workId));
        return mongoTemplate.findOne(query, Answer.class);
    }

    @Override
    public void saveAnswer(Answer answer){
        mongoTemplate.save(answer);
    }
}
