package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.TeacherRegistrationForm;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author cjk
 * @date 2020/8/24
 */
@Component
public class TeacherRegistrationTemplate {
    @Resource
    private MongoTemplate mongoTemplate;

    public TeacherRegistrationForm findByOpenId(String openId) {
        Query query = new Query(Criteria.where("openId").is(openId));
        return mongoTemplate.findOne(query, TeacherRegistrationForm.class);
    }

    public void addTeacherRegistrationForm(TeacherRegistrationForm teacherRegistrationForm) {
        mongoTemplate.save(teacherRegistrationForm);
    }

}
