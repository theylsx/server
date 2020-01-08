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

@Controller
public class TeacherController {
  @Autowired private UserTemplate userTemplate;
  @Autowired private TeacherTemplate teacherTemplate;
  @Autowired private StudentTemplate studentTemplete;

  @ResponseBody
  @PostMapping("/newTeacher")
  public String newTeacher(@RequestBody Map<String, Object> data) {
    System.out.println(data.get("OpenId").toString());
    Teacher teacher = new Teacher();
    teacher.setOpenId(data.get("OpenId").toString());
    teacher.setName(data.get("Name").toString());
    teacher.setInformation(data.get("Information").toString());
    teacher.setPlace(data.get("Place").toString());
    teacher.setEmail(data.get("Email").toString());
    User user = new User();
    user.setName(data.get("Name").toString());
    user.setOpenId(data.get("OpenId").toString());
    user.setType(1);
    teacherTemplate.save(teacher);
    userTemplate.save(user);
    return "Success";
  }

  @ResponseBody
  @PostMapping("/addMyStudent")
  public String addMyStudent(@RequestBody Map<String, Object> data) {
    System.out.println(data.get("Name").toString() + data.get("Hospital").toString());
    Student student =
        studentTemplete.findByNameAndHospital(
            data.get("Name").toString(), data.get("Hospital").toString());
    if (student == null) {
      return "fail";
    }
    String myOpenId = data.get("MyOpenId").toString();
    Teacher teacher = teacherTemplate.findByOpenId(myOpenId);
    if (student.getTeacher().contains(myOpenId)) {
      return "exist";
    }
    teacher.getAsTeacher().add(student.getOpenId());
    student.getTeacher().add(myOpenId);
    studentTemplete.save(student);
    teacherTemplate.save(teacher);
    return "addMyStudent";
  }

  @ResponseBody
  @PostMapping("/getMyStudent")
  public List<Student> getMyStudent(@RequestBody Map<String, Object>data){
    List<Student> studentList = new ArrayList<>();
    Teacher teacher = teacherTemplate.findByOpenId(data.get("OpenId").toString());
    Student student;
    for (String id: teacher.getAsTeacher()){
      student = studentTemplete.findByOpenId(id);
      studentList.add(student);
    }
    return studentList;
  }

  @ResponseBody
  @PostMapping("/getTeacher")
  public Teacher getTeacher(@RequestBody Map<String, Object> data) {
    String openid = data.get("openId").toString();
    return teacherTemplate.findByOpenId(openid);
  }
}
