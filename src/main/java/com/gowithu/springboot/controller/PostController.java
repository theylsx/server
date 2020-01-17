package com.gowithu.springboot.controller;

import com.gowithu.springboot.dao.PostTemplate;
import com.gowithu.springboot.dao.UserTemplate;
import com.gowithu.springboot.entity.Post;
import com.gowithu.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class PostController {
    @Autowired private PostTemplate postTemplate;
    @Autowired private UserTemplate userTemplate;

    @ResponseBody
    @PostMapping("/post")
    public String post(@RequestBody Map<String, Object> data) {
        Post post = new Post();
        System.out.println(data.get("Content"));
        post.setContent(data.get("Content").toString());
        post.setTitle(data.get("Title").toString());
        post.setDate(data.get("Date").toString());
        post.setPublisherId(data.get("OpenId").toString());
        post.setPublisherAvatar(data.get("UserAvatar").toString());
        postTemplate.save(post);
        post = postTemplate.findLatestByPublisherId(data.get("OpenId").toString());
        post.setStringId(post.getId().toString());
        postTemplate.save(post);
        return "post";
    }

    @ResponseBody
    @PostMapping("/getPost")
    public Map<String, Object> getPost(@RequestBody Map<String, Object> data) {
        Map<String, Object> result = new HashMap<>();
        Post post = postTemplate.findByStringId(data.get("stringId").toString());
        result.put("Title", post.getTitle());
        result.put("Content", post.getContent());
        result.put("Date", post.getDate());
        User user;
        user = userTemplate.findByOpenId(post.getPublisherId());
        result.put("Avatar", post.getPublisherAvatar());
        result.put("PublisherName", user.getName());
        return result;
    }

    @ResponseBody
    @GetMapping("/getAllPost")
    public Map<String, Object> getAllPost() {
        List<Post> postList = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();
        postList = postTemplate.findAll();
        Collections.reverse(postList);
        result.put("list", postList);
        return result;
    }
}
