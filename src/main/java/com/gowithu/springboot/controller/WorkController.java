package com.gowithu.springboot.controller;

import java.util.List;
import java.util.Map;

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

/**
 * @author david
 */
@Controller
public class WorkController {
    @Autowired
    private WorkTemplate workTemplate;
    @Autowired
    private AnswerTemplate answerTemplate;

    /**
     * 通过studentOpenId 获取该学生的所有作业的列表
     * 
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/getStudentWork")
    public List<Work> getStudentWork(@RequestBody Map<String, Object> data) {
        String studentOpenId = data.get("studentOpenId").toString();
        return workTemplate.findByStudentOpenId(studentOpenId);
    }

    /**
     * 通过teacherOpenId 获取该老师的所创建的所有作业的列表
     * 
     * @param data
     * @return
     */

    @ResponseBody
    @PostMapping("/getTeacherWork")
    public List<Work> getTeacherWork(@RequestBody Map<String, Object> data) {
        String teacherOpenId = data.get("teacherOpenId").toString();
        return workTemplate.findByTeacherOpenId(teacherOpenId);
    }

    /**
     * 新建一份作业
     * 
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/addWork")
    public String addWork(@RequestBody Map<String, Object> data) {
        Work work = new Work();
        work.setAnswer((List<String>) data.get("answer"));
        work.setDeclaration(data.get("declaration").toString());
        work.setWorkName(data.get("workName").toString());
        work.setTeacherOpenId(data.get("teacherOpenId").toString());
        work.setStudentOpenId(data.get("studentOpenId").toString());
        work.setCount((Integer.parseInt(data.get("count").toString())));
        work.setSelection((List<String[]>) data.get("selection"));
        work.setTitle((List<String>) data.get("title"));
        work.setScore(0);
        workTemplate.save(work);
        return "success";
    }

    /**
     * 根据ObjectId（id） 获取作业详细信息
     * 
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/getWork")
    public Work getWork(@RequestBody Map<String, Object> data) {
        return workTemplate.findById(new ObjectId(data.get("id").toString()));
    }

    /**
     * 根据ObjectId（id） 获取作业答案
     * 
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/getAnswer")
    public Answer getAnswer(@RequestBody Map<String, Object> data) {
        return answerTemplate.findByOpenIdAndWorkId(data.get("openId").toString(),
                new ObjectId(data.get("workId").toString()));
    }

    /**
     * 保存一份学生作业的答案，并计算得分保存到对应的作业中 answer 存 答案列表，对应的作业的objectId，以及所属学生的studentOpenId
     * 
     * @param data
     * @return
     */
    @ResponseBody
    @PostMapping("/addAnswer")
    public String addAnswer(@RequestBody Map<String, Object> data) {
        Answer answer = new Answer();
        List<String> answerList = (List<String>) data.get("answerList");
        answer.setAnswer(answerList);
        answer.setWorkId(new ObjectId(data.get("workId").toString()));
        answer.setStudentId(data.get("studentOpenId").toString());
        answerTemplate.saveAnswer(answer);
        Work work = workTemplate.findById(new ObjectId(data.get("workId").toString()));

        // 这里开始计算得分并且保存到对应的作业中
        int tmp = 0;
        for (int i = 0; i < work.getAnswer().size(); i++) {
            if (work.getAnswer().get(i).equals(answerList.get(i)))
                tmp++;
        }
        work.setScore(((float) tmp / (float) work.getCount()) * 100);
        workTemplate.save(work);
        return "Success";
    }

}
