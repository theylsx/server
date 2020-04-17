package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Work;

import org.bson.types.ObjectId;

import java.util.List;

public interface WorkTemplate {
    List<Work> findByStudentOpenId(String studentOpenId);

    List<Work> findByTeacherOpenId(String teacherOpenId);

    Work findById(ObjectId id);

    void save(Work work);
}
