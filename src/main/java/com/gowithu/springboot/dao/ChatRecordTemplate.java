package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.ChatRecord;
import com.gowithu.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatRecordTemplate {
    @Autowired private MongoTemplate mongoTemplate;

    public List<ChatRecord> findAllByStudentOpenId(String studentOpenId){
        Query query = new Query(Criteria.where("studentOpenId").is(studentOpenId));
        return  mongoTemplate.find(query, ChatRecord.class);
    }

    public ChatRecord findByStudentOpenId(String studentOpenId){
        Query query = new Query(Criteria.where("studentOpenId").is(studentOpenId));
        return  mongoTemplate.findOne(query, ChatRecord.class);
    }



    public void save(ChatRecord chatRecord){
        mongoTemplate.save(chatRecord);
    }

}
