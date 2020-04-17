package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Feedback;

import org.bson.types.ObjectId;

import java.util.List;

public interface FeedbackTemplate {
    Feedback findById(ObjectId id);

    Feedback findByTitle(String title);

    List<Feedback> findByStudentOpenId(String openId);

    void save(Feedback feedback);
}
