package com.gowithu.springboot.controller;

import com.gowithu.springboot.dao.StudentTemplate;
import com.gowithu.springboot.dao.TeacherTemplate;
import com.gowithu.springboot.dao.UserTemplate;
import com.gowithu.springboot.entity.Student;
import com.gowithu.springboot.entity.Teacher;
import com.gowithu.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** @author dav1d */
@Controller
public class StudentController {
    private final com.gowithu.springboot.dao.StudentTemplate studentTemplate;
    private final com.gowithu.springboot.dao.UserTemplate userTemplate;
    @Autowired
    private TeacherTemplate teacherTemplate;

    public StudentController(StudentTemplate studentTemplate, UserTemplate userTemplate) {
        this.studentTemplate = studentTemplate;
        this.userTemplate = userTemplate;
    }

    /**
     * 保存一个新的学生信息（注册） 同时需要保存到用户表（学生表、教师表、用户表（包括学生和教师））
     * 
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/newStudent")
    public String newStudent(@RequestBody Map<String, Object> data) {
        Student student = new Student();
        student.setOpenId(data.get("openId").toString());
        student.setName(data.get("name").toString());
        student.setHospital(data.get("hospital").toString());
        student.setInformation(data.get("information").toString());
        User user = new User();
        user.setName(data.get("name").toString());
        user.setOpenId(data.get("openId").toString());
        user.setType(0);
        studentTemplate.save(student);
        userTemplate.save(user);
        return "Success";
    }

    /**
     * 根据openId 获取一个学生的详细信息
     * 
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/getStudent")
    public Student getStudent(@RequestBody Map<String, Object> data) {
        String openid = data.get("OpenId").toString();
        return studentTemplate.findByOpenId(openid);
    }

    /**
     * 根据openId 获取当前学生的老师的列表 学生有一个属性保存着她的所有老师的openid（列表）
     * 
     * @param dataF
     * @return
     */
    @ResponseBody
    @PostMapping("/getMyTeacher")
    public List<Teacher> getMyTeacher(@RequestBody Map<String, Object> data) {
        List<Teacher> teacherList = new ArrayList<>();
        Student student = studentTemplate.findByOpenId(data.get("OpenId").toString());
        Teacher teacher;
        for (String id : student.getTeacher()) {
            teacher = teacherTemplate.findByOpenId(id);
            teacherList.add(teacher);
        }
        return teacherList;
    }
}
