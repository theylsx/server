package com.gowithu.springboot.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dav1d
 */
@Document (collection = "student")
public class Student {
  private ObjectId id;
  private String openId;
  private List<String> teacher;
  private String headTeacher;
  private String name;
  private String hospital;
  private String information;
  private String chatRecordId;

  public Student() {
    teacher = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public String getHospital() {
    return hospital;
  }

  public String getInformation() {
    return information;
  }

  public void setHospital(String hospital) {
    this.hospital = hospital;
  }

  public void setInformation(String information) {
    this.information = information;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOpenId() {
    return openId;
  }

  public String getHeadTeacher() {
    return headTeacher;
  }


  public void setHeadTeacher(String headTeacher) {
    this.headTeacher = headTeacher;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public String getChatRecordId() {
    return chatRecordId;
  }


  public ObjectId getId() {
    return id;
  }

  public void setTeacher(List<String> teacher) {
    this.teacher = teacher;
  }

  public List<String> getTeacher() {
    return teacher;
  }

  public void setChatRecordId(String chatRecordId) {
    this.chatRecordId = chatRecordId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }
}
