package com.gowithu.springboot.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


/** @author dav1d */
@Document(collection = "user")
public class User {
  private ObjectId id;
  private String openId;
  private int type;
  private String name;

  public User() {}

  public void setId(ObjectId id) {
    this.id = id;
  }

  public ObjectId getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String getOpenId() {
    return openId;
  }

  public int getType() {
    return type;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public void setType(int type) {
    this.type = type;
  }
}
