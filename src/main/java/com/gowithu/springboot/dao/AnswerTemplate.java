package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Answer;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnswerTemplate {
    Answer findByOpenIdAndWorkId(String openId, ObjectId workId);

    void saveAnswer(Answer answer);
}
