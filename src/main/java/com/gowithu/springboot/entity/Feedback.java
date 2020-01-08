package com.gowithu.springboot.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


/** @author dav1d */
@Document(collection = "feedback")
public class Feedback {
  private ObjectId id;
  private String stringId;
  private String title;
  private String studentOpenId;
  private String studentName;
  private String headTeacher;
  private String date;
  private String className;
  private String teacher;
  private String goal;
  private String classNum;
  private String offlineNum;
  private String onlineNum;
  private Integer progress;
  private Integer difficulty;
  private Integer method;
  private Integer attitude;
  private String gains;
  private String recommend;

  public void setId(ObjectId id) {
    this.id = id;
  }

  public void setStudentOpenId(String studentOpenId) {
    this.studentOpenId = studentOpenId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setStringId(String stringId) {
    this.stringId = stringId;
  }

  public String getStringId() {
    return stringId;
  }

  public String getTitle() {
    return title;
  }

  public String getStudentOpenId() {
    return studentOpenId;
  }

  public void setTeacher(String teacher) {
    this.teacher = teacher;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setHeadTeacher(String headTeacher) {
    this.headTeacher = headTeacher;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public void setAttitude(Integer attitude) {
    this.attitude = attitude;
  }

  public ObjectId getId() {
    return id;
  }

  public void setClassNum(String classNum) {
    this.classNum = classNum;
  }

  public void setDifficulty(Integer difficulty) {
    this.difficulty = difficulty;
  }

  public void setGains(String gains) {
    this.gains = gains;
  }

  public void setGoal(String goal) {
    this.goal = goal;
  }

  public void setMethod(Integer method) {
    this.method = method;
  }

  public void setOfflineNum(String offlineNum) {
    this.offlineNum = offlineNum;
  }

  public void setOnlineNum(String onlineNum) {
    this.onlineNum = onlineNum;
  }

  public void setProgress(Integer progress) {
    this.progress = progress;
  }

  public void setRecommend(String recommend) {
    this.recommend = recommend;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getDate() {
    return date;
  }

  public String getTeacher() {
    return teacher;
  }

  public String getHeadTeacher() {
    return headTeacher;
  }

  public Integer getAttitude() {
    return attitude;
  }

  public Integer getDifficulty() {
    return difficulty;
  }

  public Integer getMethod() {
    return method;
  }

  public Integer getProgress() {
    return progress;
  }

  public String getClassName() {
    return className;
  }

  public String getClassNum() {
    return classNum;
  }

  public String getGains() {
    return gains;
  }

  public String getGoal() {
    return goal;
  }

  public String getOfflineNum() {
    return offlineNum;
  }

  public String getOnlineNum() {
    return onlineNum;
  }

  public String getRecommend() {
    return recommend;
  }

  public String getStudentName() {
    return studentName;
  }
}

