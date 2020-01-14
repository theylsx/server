package com.gowithu.springboot.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "chatRecord")
public class ChatRecord {
    private ObjectId id;
    private String stringId;
    private String studentOpenId;
    private String teacherOpenId;
    private String chatContent;
    private String speaker;

    public ObjectId getId() {
        return id;
    }

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getStudentOpenId() {
        return studentOpenId;
    }

    public void setStudentOpenId(String studentOpenId) {
        this.studentOpenId = studentOpenId;
    }

    public String getTeacherOpenId() {
        return teacherOpenId;
    }

    public void setTeacherOpenId(String teacherOpenId) {
        this.teacherOpenId = teacherOpenId;
    }

    public String getChatContent() {
        return chatContent;
    }

    public void setChatContent(String chatContent) {
        this.chatContent = chatContent;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
}
