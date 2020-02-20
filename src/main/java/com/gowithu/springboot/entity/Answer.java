package com.gowithu.springboot.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author dav1d
 */
@Document(collection = "answer")
public class Answer {
    ObjectId id;
    ObjectId workId;
    String studentId;
    List<String> answer;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getWorkId() {
        return workId;
    }

    public void setWorkId(ObjectId workId) {
        this.workId = workId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}
