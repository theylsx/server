package com.goWithU.springboot01.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "student")
public class Student {
  @Id private String openId;
  private String teacher;
  private String headTeacher;
  private String name;
  private String hospital;
  private String information;

  public Student() {}

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

  public void setInformation(String infomation) {
    this.information = infomation;
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

  public String getTeacher() {
    return teacher;
  }

  public void setHeadTeacher(String headTeacher) {
    this.headTeacher = headTeacher;
  }

  public void setTeacher(String teacher) {
    this.teacher = teacher;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }
}
