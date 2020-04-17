package com.gowithu.springboot.dao.impl.mongodb;

import com.gowithu.springboot.entity.ChatRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatRecordTemplateImpl implements com.gowithu.springboot.dao.ChatRecordTemplate {
    @Autowired private MongoTemplate mongoTemplate;

    @Override
    public List<ChatRecord> findAllByStudentOpenId(String studentOpenId){
        Query query = new Query(Criteria.where("studentOpenId").is(studentOpenId));
        return  mongoTemplate.find(query, ChatRecord.class);
    }

    @Override
    public ChatRecord findByStudentOpenId(String studentOpenId){
        Query query = new Query(Criteria.where("studentOpenId").is(studentOpenId));
        return  mongoTemplate.findOne(query, ChatRecord.class);
    }



    @Override
    public void save(ChatRecord chatRecord){
        mongoTemplate.save(chatRecord);
    }

}
