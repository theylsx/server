package com.gowithu.springboot.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author cjk
 * @date 2020/8/20
 *
 */
@Document(collection = "studentRegistrationForm")
public class StudentRegistrationForm {
    private ObjectId id;
    private String name;
    private String phone;
    private String hospitalName;
    private String subject;
    private String grade;
    private String sex;
    private String claim;
    private String remark;
    private String openId;

    public StudentRegistrationForm() {
    }

    public StudentRegistrationForm(String name, String phone, String hospitalName, String subject, String grade, String sex, String claim, String remark, String openId) {
        this.name = name;
        this.phone = phone;
        this.hospitalName = hospitalName;
        this.subject = subject;
        this.grade = grade;
        this.sex = sex;
        this.claim = claim;
        this.remark = remark;
        this.openId = openId;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClaim() {
        return claim;
    }

    public void setClaim(String claim) {
        this.claim = claim;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
