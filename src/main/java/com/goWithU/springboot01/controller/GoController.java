package com.goWithU.springboot01.controller;

import com.goWithU.springboot01.Entity.Post;
import com.goWithU.springboot01.Entity.User;
import com.goWithU.springboot01.dao.PostRepository;
import com.goWithU.springboot01.dao.UserRepository;
import com.goWithU.springboot01.Entity.Student;
import com.goWithU.springboot01.Entity.Teacher;
import com.goWithU.springboot01.dao.StudentRepository;
import com.goWithU.springboot01.dao.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** @author dav1d */
@Controller
public class GoController {
  String appId = "wx882769e007a9573e";
  String secret = "55867e74554df906a8f7d81036c91fa4";

  @Autowired UserRepository userRepository;
  @Autowired TeacherRepository teacherRepository;
  @Autowired StudentRepository studentRepository;
  @Autowired PostRepository postRepository;

  @ResponseBody
  @PostMapping("/getOpenId")
  public String getOpenId(@RequestBody Map<String, Object> data) throws IOException {
    String code = data.get("code").toString();
    System.out.println(code);
    File dir = new File("");
    // String[] arguments = new String[] {"python", dir, code};
    List<String> result = new ArrayList<>();
    try {
      System.out.println(dir.getAbsolutePath().replace("\\", "\\\\"));
      Process process =
          Runtime.getRuntime()
              .exec("python " + dir.getAbsolutePath() + "/python/getOpenid.py" + " " + code);
      process.waitFor();
      BufferedReader in =
          new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
      BufferedReader in1 =
          new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));
      String line = null;
      while ((line = in.readLine()) != null) {
        result.add(line);
        System.out.println(line);
      }
      while ((line = in1.readLine()) != null) {
        System.out.println(line);
      }
      in.close();
      // java代码中的process.waitFor()返回值为0表示我们调用python脚本成功，
      // 返回值为1表示调用python脚本失败，这和我们通常意义上见到的0与1定义正好相反
      int re = process.waitFor();
      System.out.println(re);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(result.toString());
    return result.get(0);
  }

  @ResponseBody
  @PostMapping("/goWithU")
  public User judgeNewUser(@RequestBody Map<String, Object> data) {
    System.out.println(data.get("openId"));
    return userRepository.findByopenId(data.get("openId").toString());
  }

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
    teacherRepository.save(teacher);
    userRepository.save(user);
    return "Success";
  }

  @ResponseBody
  @PostMapping("/newStudent")
  public String newStudent(@RequestBody Map<String, Object> data) {
    System.out.println(data.get("OpenId").toString());
    Student student = new Student();
    student.setOpenId(data.get("OpenId").toString());
    student.setName(data.get("Name").toString());
    student.setHospital(data.get("Hospital").toString());
    student.setInformation(data.get("Information").toString());
    User user = new User();
    user.setName(data.get("Name").toString());
    user.setOpenId(data.get("OpenId").toString());
    user.setType(0);
    studentRepository.save(student);
    userRepository.save(user);
    return "Success";
  }

  @ResponseBody
  @PostMapping("/post")
  public String post(@RequestBody Map<String, Object> data) {
    Post post = new Post();
    System.out.println(data.get("Content"));
    post.setContent(data.get("Content").toString());
    post.setTitle(data.get("Title").toString());
    post.setDate(data.get("Date").toString());
    post.setPublisher_id(data.get("OpenId").toString());
    post.setPublisher_avatar(data.get("UserAvatar").toString());
    postRepository.save(post);
    return "post";
  }

  @ResponseBody
  @PostMapping("/getPost")
  public Map<String, Object> getPost(@RequestBody Map<String, Object> data) {
    Map<String, Object> result = new HashMap<>();
    Post post = postRepository.findById(Integer.valueOf(data.get("Id").toString())).get();
    result.put("Title", post.getTitle());
    result.put("Content", post.getContent());
    result.put("Date", post.getDate());
    User user;
    user = userRepository.findByopenId(post.getPublisher_id());
    result.put("Avatar", post.getPublisher_avatar());
    result.put("PublisherName", user.getName());
    return result;
  }

  @ResponseBody
  @GetMapping("/getAllPost")
  public Map<String, Object> getAllPost() {
    List<Post> postList = new ArrayList<>();
    Map<String, Object> result = new HashMap<>();
    postList = postRepository.findAll();
    result.put("list", postList);
    return result;
  }

  @ResponseBody
  @PostMapping("/addMyStudent")
  public String addMyStudent(@RequestBody Map<String, Object> data) {
    System.out.println(data.get("Name").toString() + data.get("Hospital").toString());
    Student student =
        studentRepository.findByNameAndHospital(
            data.get("Name").toString(), data.get("Hospital").toString());
    if (student == null) {
      return "fail";
    }
    String myOpenId = data.get("MyOpenId").toString();
    Teacher teacher = teacherRepository.findByOpenId(myOpenId);
    if (student.getTeacher().contains(myOpenId)){
      return "exist";
    }
    if ("null".equals(teacher.getAsTeacher())) {
      teacher.setAsTeacher(student.getOpenId() + "`");
    } else {
      teacher.setAsTeacher(teacher.getAsTeacher() + student.getOpenId() + "`");
    }
    if ("null".equals(student.getTeacher())) {
      student.setTeacher(myOpenId + "`");
    } else {
      student.setTeacher(student.getTeacher() + myOpenId + "`");
    }
    studentRepository.save(student);
    teacherRepository.save(teacher);
    return "addMyStudent";
  }

  @ResponseBody
  @PostMapping("/getMyStudent")
  public List<Student> getMyStudent(@RequestBody Map<String, Object>data){
    List<Student> studentList = new ArrayList<>();
    Teacher teacher = teacherRepository.findByOpenId(data.get("OpenId").toString());
    String[] studentId = teacher.getAsTeacher().split("`");
    Student student;
    for (String id: studentId){
      student = studentRepository.findByOpenId(id);
      studentList.add(student);
    }
    return studentList;
  }

  @ResponseBody
  @PostMapping("/getStudent")
  public Student getStudent(@RequestBody Map<String, Object> data){
    String openid = data.get("OpenId").toString();
    Student student = studentRepository.findByOpenId(openid);
    return student;
  }

}
