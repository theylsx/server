package com.goWithU.springboot01.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/** @author dav1d */
@Entity(name = "teacher")
public class Teacher {
  @Id private String openId;
  private String asTeacher;
  private String asHeadTeacher;
  private String name;
  private String email;
  private String place;
  private String Information;
  private int access;

  public Teacher() {}

  public String getAsHeadTeacher() {
    return asHeadTeacher;
  }

  public String getInformation() {
    return Information;
  }

  public void setInformation(String infromation) {
    Information = infromation;
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

  public String getAsTeacher() {
    return asTeacher;
  }

  public String getOpenId() {
    return openId;
  }

  public void setAsHeadTeacher(String asHeadTeacher) {
    this.asHeadTeacher = asHeadTeacher;
  }

  public void setAsTeacher(String asTeacher) {
    this.asTeacher = asTeacher;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }
}
