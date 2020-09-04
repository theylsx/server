package com.gowithu.springboot.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.gowithu.springboot.entity.Work;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * @author david
 */
@Component
public class WorkTemplate {
    static String id = "5e5ce88c92d09f52638ab24f";

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Work> findByStudentOpenId(String studentOpenId) {
        Query query = Query.query(Criteria.where("studentOpenId").is(studentOpenId));
        List<Work> res = mongoTemplate.find(query, Work.class);
        res.add(findById(new ObjectId(id)));
        res = res.stream().distinct().collect(Collectors.toList());
        return res;
    }

    public List<Work> findByTeacherOpenId(String teacherOpenId) {
        Query query = Query.query(Criteria.where("teacherOpenId").is(teacherOpenId));
        List<Work> res = mongoTemplate.find(query, Work.class);
        res.add(findById(new ObjectId(id)));
        res = res.stream().distinct().collect(Collectors.toList());
        return res;

    }

    public Work findById(ObjectId id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, Work.class);
    }

    public void save(Work work) {
        mongoTemplate.save(work);
    }

    public void uploadWorkPictureFilePath(String filePath, ObjectId id) {
        Work work = findById(id);
        List<String> pl = work.getPictureList();
        pl.add(filePath);
        work.setPictureList(pl);
    }

}
