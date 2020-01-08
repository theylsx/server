package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class StudentTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Student findByOpenId(String openId){
        Query query = new Query(Criteria.where("openId").is(openId));
        return mongoTemplate.findOne(query, Student.class);
    }

    public Student findByNameAndHospital(String name, String hospital){
        Query query = new Query(Criteria.where("name").is(name).and("hospital").is(hospital));
        return mongoTemplate.findOne(query, Student.class);
    }

    public void save(Student student){
        mongoTemplate.save(student);
    }
}
