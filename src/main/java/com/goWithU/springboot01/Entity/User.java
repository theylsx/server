package com.goWithU.springboot01.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author dav1d
 */
@Entity(name = "user")
public class User {
    @Id
    private String openId;
    private int type;

    public User(String openId, int type){
        this.openId = openId;
        this.type = type;
    }
    public User(){}

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
