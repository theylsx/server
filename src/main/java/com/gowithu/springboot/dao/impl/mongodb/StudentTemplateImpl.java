package com.gowithu.springboot.dao.impl.mongodb;

import com.gowithu.springboot.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class StudentTemplateImpl implements com.gowithu.springboot.dao.StudentTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Student findByOpenId(String openId){
        Query query = new Query(Criteria.where("openId").is(openId));
        return mongoTemplate.findOne(query, Student.class);
    }

    @Override
    public Student findByNameAndHospital(String name, String hospital){
        Query query = new Query(Criteria.where("name").is(name).and("hospital").is(hospital));
        return mongoTemplate.findOne(query, Student.class);
    }

    @Override
    public void save(Student student){
        mongoTemplate.save(student);
    }
}
