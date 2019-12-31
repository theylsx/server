package com.goWithU.springboot01.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "post")
public class Post {
    @Id
    private int id;
    private String title;
    private String context;
    private String publisher_id;

    public void setId(int id) {
        this.id = id;
    }

    public void setContext(String context) {
        this.context = context;
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

    public String getContext() {
        return context;
    }

    public String getPublisher_id() {
        return publisher_id;
    }

    public String getTitle() {
        return title;
    }
}
