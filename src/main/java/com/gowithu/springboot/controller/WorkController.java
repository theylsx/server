package com.gowithu.springboot.controller;

import com.gowithu.springboot.dao.AnswerTemplate;
import com.gowithu.springboot.dao.WorkTemplate;
import com.gowithu.springboot.entity.Answer;
import com.gowithu.springboot.entity.Work;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author david
 */
@Controller
public class WorkController {
    @Autowired private WorkTemplate workTemplate;
    @Autowired private AnswerTemplate answerTemplate;

    @ResponseBody
    @PostMapping("/getStudentWork")
    public List<Work> getStudentWork(@RequestBody Map<String, Object> data){
        String studentOpenId = data.get("studentOpenId").toString();
        return workTemplate.findByStudentOpenId(studentOpenId);
    }

    @ResponseBody
    @PostMapping("/getTeacherWork")
    public List<Work> getTeacherWork(@RequestBody Map<String, Object> data){
        String teacherOpenId = data.get("teacherOpenId").toString();
        return workTemplate.findByTeacherOpenId(teacherOpenId);
    }

    @ResponseBody
    @PostMapping("/addWork")
    public String addWork(@RequestBody Map<String, Object> data){
        Work work = new Work();
        work.setAnswer((List<String>) data.get("answer"));
        work.setDeclaration(data.get("declaration").toString());
        work.setWorkName(data.get("workName").toString());
        work.setTeacherOpenId(data.get("teacherOpenId").toString());
        work.setStudentOpenId(data.get("studentOpenId").toString());
        work.setCount((Integer) data.get("count"));
        work.setSelection((List<String[]>) data.get("selection"));
        work.setTitle((List<String>) data.get("title"));
        work.setScore(0);
        workTemplate.save(work);
        return "success";
    }

    @ResponseBody
    @PostMapping("/getWork")
    public Work getWork(@RequestBody Map<String, Object> data){
        return workTemplate.findById(new ObjectId(data.get("id").toString()));
    }

    @ResponseBody
    @PostMapping("/getAnswer")
    public Answer getAnswer(@RequestBody Map<String, Object> data){
        return answerTemplate.findByOpenIdAndWorkId(data.get("openId").toString(), new ObjectId(data.get("workId").toString()));
    }

    @ResponseBody
    @PostMapping("/addAnswer")
    public String addAnswer(@RequestBody Map<String, Object> data) {
        //TODO: process POST request
        Answer answer = new Answer();
        List<String> answerList = (List<String>) data.get("answerList");
        answer.setAnswer(answerList);
        answer.setWorkId(new ObjectId(data.get("workId").toString()));
        answer.setStudentId(data.get("studentOpenId").toString());
        answerTemplate.saveAnswer(answer);
        Work work = workTemplate.findById(new ObjectId(data.get("workId").toString()));
        int tmp = 0;
        for (int i = 0; i< work.getAnswer().size(); i++){
            if(work.getAnswer().get(i).equals(answerList.get(i))) tmp++;
        }
        System.out.println(tmp);
        work.setScore(((float)tmp / (float)work.getCount())*100);
        workTemplate.save(work);
        return "Success";
    }
    


}
