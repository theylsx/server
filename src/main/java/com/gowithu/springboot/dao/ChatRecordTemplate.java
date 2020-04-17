package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.ChatRecord;

import java.util.List;

public interface ChatRecordTemplate {
    List<ChatRecord> findAllByStudentOpenId(String studentOpenId);

    ChatRecord findByStudentOpenId(String studentOpenId);

    void save(ChatRecord chatRecord);
}
