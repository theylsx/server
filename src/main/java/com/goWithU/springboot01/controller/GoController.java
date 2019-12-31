package com.goWithU.springboot01.controller;

import com.goWithU.springboot01.Entity.User;
import com.goWithU.springboot01.dao.UserRepository;
import com.goWithU.springboot01.Entity.Student;
import com.goWithU.springboot01.Entity.Teacher;
import com.goWithU.springboot01.dao.StudentRepository;
import com.goWithU.springboot01.dao.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** @author dav1d */
@Controller
public class GoController {
  String appId = "wx882769e007a9573e";
  String secret = "55867e74554df906a8f7d81036c91fa4";

  @Autowired
  UserRepository userRepository;
  @Autowired TeacherRepository teacherRepository;
  @Autowired StudentRepository studentRepository;

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
          Runtime.getRuntime().exec("python " + dir.getAbsolutePath() + "/python/getOpenid.py"+  " " +code);
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
      while ((line = in1.readLine()) != null){
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
    User user = new User(data.get("OpenId").toString(), 1);
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
    User user = new User(data.get("OpenId").toString(), 1);
    studentRepository.save(student);
    userRepository.save(user);
    return "Success";
  }
}
