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
  private final StudentTemplate studentTemplate;
  private final UserTemplate userTemplate;
  @Autowired private TeacherTemplate teacherTemplate;

  public StudentController(StudentTemplate studentTemplate, UserTemplate userTemplate) {
    this.studentTemplate = studentTemplate;
    this.userTemplate = userTemplate;
  }

  @ResponseBody
  @PostMapping("/newStudent")
  public String newStudent(@RequestBody Map<String, Object> data) {
    System.out.println(data.get("openId").toString());
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

  @ResponseBody
  @PostMapping("/getStudent")
  public Student getStudent(@RequestBody Map<String, Object> data) {
    String openid = data.get("OpenId").toString();
    return studentTemplate.findByOpenId(openid);
  }

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
