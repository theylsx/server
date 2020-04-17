package com.gowithu.springboot.dao.impl.mongodb;

import com.gowithu.springboot.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherTemplateImpl implements com.gowithu.springboot.dao.TeacherTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Teacher findByOpenId(String openId){
        Query query = new Query(Criteria.where("openId").is(openId));
        return mongoTemplate.findOne(query, Teacher.class);
    }

    @Override
    public void save(Teacher teacher){
       mongoTemplate.save(teacher);
    }

    @Override
    public Teacher findByNameAndOrganization(String name, String place){
        Query query = new Query(Criteria.where("name").is(name).and("place").is(place));
        Teacher teacher = mongoTemplate.findOne(query, Teacher.class);
        return teacher;
    }

}
