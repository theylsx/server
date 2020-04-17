package com.gowithu.springboot.service;

import com.gowithu.springboot.entity.ChatRecord;

import java.util.List;

public interface ChatRecordService {
    List<ChatRecord> getChatRecords(String studentOpenID);
    boolean addStudentChatToList(ChatRecord chatRecord);
    boolean addTeacherChatToList(ChatRecord chatRecord);
}
