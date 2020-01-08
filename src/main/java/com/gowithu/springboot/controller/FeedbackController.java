package com.gowithu.springboot.controller;

import com.gowithu.springboot.dao.FeedbackTemplate;
import com.gowithu.springboot.dao.StudentTemplate;
import com.gowithu.springboot.entity.Feedback;
import com.gowithu.springboot.entity.Student;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class FeedbackController {
  @Autowired private FeedbackTemplate feedbackTemplate;
  @Autowired private StudentTemplate studentTemplate;

  @ResponseBody
  @PostMapping("/getFeedback")
  public Feedback getFeedback(@RequestBody Map<String, Object> data) {
      String stringId = data.get("stringId").toString();
    return feedbackTemplate.findByStringId(stringId);
  }

  @ResponseBody
  @PostMapping("/getFeedbackList")
  public List<Feedback> getFeedbackList(@RequestBody Map<String, Object> data) {
    String openId = data.get("openId").toString();
    System.out.println(feedbackTemplate.findByStudentOpenId(openId).get(0).toString());
    return feedbackTemplate.findByStudentOpenId(openId);
  }

  @ResponseBody
  @PostMapping("/addFeedback")
  public String addFeedback(@RequestBody Map<String, Object> data) {
    String studentOpenId = data.get("studentOpenId").toString();
    Feedback feedback = new Feedback();
    Student student = studentTemplate.findByOpenId(studentOpenId);
    String studentName = student.getName();
    int times = feedbackTemplate.findByStudentOpenId(studentOpenId).size();
    String title = studentName + " 第 " + String.valueOf(times + 1) + " 次课教学反馈表";
    feedback.setStudentOpenId(studentOpenId);
    feedback.setTitle(title);
    feedbackTemplate.save(feedback);
    feedback = feedbackTemplate.findByTitle(title);
    feedback.setStringId(feedback.getId().toString());
    feedbackTemplate.save(feedback);
    return "success";
  }

  @ResponseBody
  @PostMapping("/saveFeedback")
  public String saveFeedback(@RequestBody Map<String, Object> data) {
//    System.out.println(data.get("id").toString());
//    ObjectId id = (ObjectId) data.get("id");
//    String studentOpenId = data.get("studentOpenId").toString();
    String stringId = data.get("stringId").toString();
    System.out.println(stringId);
    String studentName = data.get("studentName").toString();
    String headTeacher = data.get("headTeacher").toString();
    String date = data.get("date").toString();
    String className = data.get("className").toString();
    String teacher = data.get("teacher").toString();
    String goal = data.get("goal").toString();
    String classNum = data.get("classNum").toString();
    String offlineNum = data.get("offlineNum").toString();
    String onlineNum = data.get("onlineNum").toString();
    Integer progress = Integer.valueOf(data.get("progress").toString());
    Integer difficulty = Integer.valueOf(data.get("difficulty").toString());
    Integer method = Integer.valueOf(data.get("method").toString());
    Integer attitude = Integer.valueOf(data.get("attitude").toString());
    String gains = data.get("gains").toString();
    String recommend = data.get("recommend").toString();
    Feedback feedback = feedbackTemplate.findByStringId(stringId);
    //    feedback.setStudentOpenId(studentOpenId);
    //      feedback.setId(id);
    feedback.setStudentName(studentName);
    feedback.setHeadTeacher(headTeacher);
    feedback.setDate(date);
    feedback.setClassName(className);
    feedback.setTeacher(teacher);
    feedback.setGoal(goal);
    feedback.setGains(gains);
    feedback.setClassNum(classNum);
    feedback.setOfflineNum(offlineNum);
    feedback.setOnlineNum(onlineNum);
    feedback.setProgress(progress);
    feedback.setDifficulty(difficulty);
    feedback.setMethod(method);
    feedback.setAttitude(attitude);
    feedback.setRecommend(recommend);
    feedbackTemplate.save(feedback);

    return "success";
  }
}
