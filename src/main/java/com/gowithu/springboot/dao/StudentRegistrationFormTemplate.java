package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.StudentRegistrationForm;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author cjk
 * @date 2020/8/21
 */
@Component
public class StudentRegistrationFormTemplate {
    @Resource
    private MongoTemplate mongoTemplate;

    public StudentRegistrationForm findByOpenId(String openId) {
        Query query = new Query(Criteria.where("openId").is(openId));
        return mongoTemplate.findOne(query, StudentRegistrationForm.class);
    }

    public void addStudentRegistrationForm(StudentRegistrationForm studentRegistrationForm) {
        mongoTemplate.save(studentRegistrationForm);
    }
}
