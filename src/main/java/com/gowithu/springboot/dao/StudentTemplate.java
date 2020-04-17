package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Student;

public interface StudentTemplate {
    Student findByOpenId(String openId);

    Student findByNameAndHospital(String name, String hospital);

    void save(Student student);
}
