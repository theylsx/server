package com.gowithu.springboot.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "post")
public class Post {
  private ObjectId id;
  private String title;
  private String content;
  private String publisherId;
  private String publisherName;
  private String date;
  private String publisherAvatar;


public void setPublisherName(String name){
    this.publisherName = name;
}

    public String getPublisherName(){
        return this.publisherName;
    }

  public void setDate(String date) {
    this.date = date;
  }

  public void setPublisherAvatar(String publisherAvatar) {
    this.publisherAvatar = publisherAvatar;
  }

  public String getPublisherAvatar() {
    return publisherAvatar;
  }

  public String getDate() {
    return date;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public void setContent(String context) {
    this.content = context;
  }

  public void setPublisherId(String publisherId) {
    this.publisherId = publisherId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ObjectId getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public String getPublisherId() {
    return publisherId;
  }

  public String getTitle() {
    return title;
  }
}
