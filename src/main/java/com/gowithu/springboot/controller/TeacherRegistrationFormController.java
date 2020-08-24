package com.gowithu.springboot.controller;

import com.gowithu.springboot.dao.TeacherRegistrationTemplate;
import com.gowithu.springboot.entity.TeacherRegistrationForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author cjk
 * @date 2020/8/24
 */
@Controller
public class TeacherRegistrationFormController {
    @Resource
    private TeacherRegistrationTemplate teacherRegistrationTemplate;

    @ResponseBody
    @PostMapping("/addTeacherRegistrationForm")
    public String addTeacherRegistrationForm(@RequestBody Map<String, Object> data) {
        String name = data.get("name").toString();
        String phone = data.get("phone").toString();
        String schoolName = data.get("schoolName").toString();
        String teacherGrade = data.get("teacherGrade").toString();
        String faculty = data.get("faculty").toString();
        String sex = data.get("sex").toString();
        String studentSubject = data.get("studentSubject").toString();
        String studentGrade = data.get("studentGrade").toString();
        String introduction = data.get("introduction").toString();
        String remark = data.get("remark").toString();
        String openId = data.get("openId").toString();

        TeacherRegistrationForm teacherRegistrationForm = teacherRegistrationTemplate.findByOpenId(openId);

        if (teacherRegistrationForm == null) {
            teacherRegistrationForm = new TeacherRegistrationForm(name, phone, schoolName, teacherGrade, faculty, sex, studentSubject, studentGrade, introduction, remark, openId);
        } else {
            teacherRegistrationForm.setName(name);
            teacherRegistrationForm.setPhone(phone);
            teacherRegistrationForm.setSchoolName(schoolName);
            teacherRegistrationForm.setTeacherGrade(teacherGrade);
            teacherRegistrationForm.setFaculty(faculty);
            teacherRegistrationForm.setSex(sex);
            teacherRegistrationForm.setStudentSubject(studentSubject);
            teacherRegistrationForm.setStudentGrade(studentGrade);
            teacherRegistrationForm.setIntroduction(introduction);
            teacherRegistrationForm.setRemark(remark);
        }
        teacherRegistrationTemplate.addTeacherRegistrationForm(teacherRegistrationForm);
        return "success";
    }
}
