package com.gowithu.springboot.controller;

import com.gowithu.springboot.dao.StudentRegistrationFormTemplate;
import com.gowithu.springboot.entity.StudentRegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author cjk
 * @date 2020/8/20
 */
@Controller
public class StudentRegistrationFormController {

    @Resource
    private StudentRegistrationFormTemplate studentRegistrationFormTemplate;

    @ResponseBody
    @PostMapping("/addStudentRegistrationForm")
    public String addStudentRegistrationForm(@RequestBody Map<String, Object> data) {

        String name = data.get("name").toString();
        String phone = data.get("phone").toString();
        String hospitalName = data.get("hospitalName").toString();
        String subject = data.get("subject").toString();
        String grade = data.get("grade").toString();
        String sex = data.get("sex").toString();
        String claim = data.get("claim").toString();
        String remark = data.get("remark").toString();
        String openId = data.get("openId").toString();

        StudentRegistrationForm studentRegistrationForm = studentRegistrationFormTemplate.findByOpenId(openId);

        if (studentRegistrationForm == null) {
            studentRegistrationForm = new StudentRegistrationForm(name, phone, hospitalName, subject, grade, sex, claim, remark, openId);
        } else {
            studentRegistrationForm.setName(name);
            studentRegistrationForm.setPhone(phone);
            studentRegistrationForm.setHospitalName(hospitalName);
            studentRegistrationForm.setSubject(subject);
            studentRegistrationForm.setGrade(grade);
            studentRegistrationForm.setSex(sex);
            studentRegistrationForm.setClaim(claim);
            studentRegistrationForm.setRemark(remark);
        }
        studentRegistrationFormTemplate.addStudentRegistrationForm(studentRegistrationForm);
        return "success";
    }
}
