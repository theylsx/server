package com.gowithu.springboot.service;

import com.gowithu.springboot.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    Feedback getFeedback(String id);
    List<Feedback> getFeedbackList(String openID);

}
