package com.gowithu.springboot.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author cjk
 * @date 2020/8/24
 */
@Document(collection = "teacherRegistrationForm")
public class TeacherRegistrationForm {
    private ObjectId id;
    private String name;
    private String phone;
    private String schoolName;
    private String teacherGrade;
    private String faculty;
    private String sex;
    private String studentSubject;
    private String studentGrade;
    private String introduction;
    private String remark;
    private String openId;

    public TeacherRegistrationForm() {
    }

    public TeacherRegistrationForm(String name, String phone, String schoolName, String teacherGrade, String faculty, String sex, String studentSubject, String studentGrade, String introduction, String remark, String openId) {
        this.name = name;
        this.phone = phone;
        this.schoolName = schoolName;
        this.teacherGrade = teacherGrade;
        this.faculty = faculty;
        this.sex = sex;
        this.studentSubject = studentSubject;
        this.studentGrade = studentGrade;
        this.introduction = introduction;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getTeacherGrade() {
        return teacherGrade;
    }

    public void setTeacherGrade(String teacherGrade) {
        this.teacherGrade = teacherGrade;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStudentSubject() {
        return studentSubject;
    }

    public void setStudentSubject(String studentSubject) {
        this.studentSubject = studentSubject;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
