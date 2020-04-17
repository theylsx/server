package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Teacher;

public interface TeacherTemplate {
    Teacher findByOpenId(String openId);

    void save(Teacher teacher);

    Teacher findByNameAndOrganization(String name, String place);
}
