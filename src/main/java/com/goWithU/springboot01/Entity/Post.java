package com.goWithU.springboot01.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "post")
public class Post {
    @Id
    private int id;
    private String title;
    @Lob
    private String content;
    private String publisher_id;
    private String date;
    private String publisher_avatar;

    public void setDate(String date) {
        this.date = date;
    }

    public void setPublisher_avatar(String publisher_avatar) {
        this.publisher_avatar = publisher_avatar;
    }

    public String getPublisher_avatar() {
        return publisher_avatar;
    }

    public String getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String context) {
        this.content = context;
    }

    public void setPublisher_id(String publisher_id) {
        this.publisher_id = publisher_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getPublisher_id() {
        return publisher_id;
    }

    public String getTitle() {
        return title;
    }
}
