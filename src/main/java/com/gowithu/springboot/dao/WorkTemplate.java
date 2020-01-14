package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author david
 */
@Component
public class WorkTemplate {
    @Autowired private MongoTemplate mongoTemplate;

    public List<Work> findByStudentOpenId(String studentOpenId){
        Query query = Query.query(Criteria.where("studentOpenId").is(studentOpenId));
        return mongoTemplate.find(query, Work.class);
    }

    public List<Work> findByTeacherOpenId(String teacherOpenId){
        Query query = Query.query(Criteria.where("teacherOpenId").is(teacherOpenId));
        return mongoTemplate.find(query, Work.class);
    }

//    public Work findOneWorkBy

    public void save(Work work){
        mongoTemplate.save(work);
    }

}
