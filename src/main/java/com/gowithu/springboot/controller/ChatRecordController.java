package com.gowithu.springboot.controller;

import com.gowithu.springboot.dao.ChatRecordTemplate;
import com.gowithu.springboot.entity.ChatRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class ChatRecordController {
    @Autowired private ChatRecordTemplate chatRecordTemplate;

    @ResponseBody
    @PostMapping("/getChatRecord")
    public List<ChatRecord> getChatRecord(@RequestBody Map<String,Object> data){
        String studentOpenId = data.get("studentOpenId").toString();
        return chatRecordTemplate.findAllByStudentOpenId(studentOpenId);
    }


    @ResponseBody
    @PostMapping("/addStudentChatToList")
    public String addStudentChatTolist(@RequestBody Map<String,Object> data){
        String studentOpenId = data.get("studentOpenId").toString();
        String chatContent = data.get("chatContent").toString();
        System.out.println(chatContent + "内容");
        ChatRecord chatRecord = new ChatRecord();
        chatRecord.setStudentOpenId(studentOpenId);
        chatRecord.setChatContent(chatContent);

        chatRecordTemplate.save(chatRecord);

        return "success";
    }


    @ResponseBody
    @PostMapping("/addTeacherChatToList")
    public String addTeacherChatTolist(@RequestBody Map<String,Object> data){
        String studentOpenId = data.get("studentOpenId").toString();
        String teacherOpenId = data.get("teacherOpenId").toString();
        String chatContent = data.get("chatContent").toString();

        ChatRecord chatRecord = new ChatRecord();

        chatRecord.setStudentOpenId(studentOpenId);
        chatRecord.setChatContent(chatContent);
        chatRecord.setTeacherOpenId(teacherOpenId);
        chatRecord.setSpeaker(teacherOpenId);

        chatRecordTemplate.save(chatRecord);

        chatRecord = chatRecordTemplate.findByStudentOpenId(studentOpenId);
        chatRecord.setStringId(chatRecord.getId().toString());
        chatRecordTemplate.save(chatRecord);
        return "success";
    }



}
