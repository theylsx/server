package com.gowithu.springboot.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/** @author dav1d */
@Document (collection = "teacher")
public class Teacher {
  private ObjectId id;
  private String openId;
  private List<String> asTeacher;
  private String asHeadTeacher;
  private String name;
  private String email;
  private String place;
  private String information;
  private int access;

  public Teacher() {
    asTeacher = new ArrayList<>();
  }

  public String getAsHeadTeacher() {
    return asHeadTeacher;
  }

  public String getInformation() {
    return information;
  }

  public void setInformation(String information) {
    this.information = information;
  }

  public int getAccess() {
    return access;
  }

  public String getEmail() {
    return email;
  }

  public String getPlace() {
    return place;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setAccess(int access) {
    this.access = access;
  }


  public String getOpenId() {
    return openId;
  }

  public void setAsHeadTeacher(String asHeadTeacher) {
    this.asHeadTeacher = asHeadTeacher;
  }


  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public ObjectId getId() {
    return id;
  }

  public void setAsTeacher(List<String> asTeacher) {
    this.asTeacher = asTeacher;
  }

  public List<String> getAsTeacher() {
    return asTeacher;
  }
}

