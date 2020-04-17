package com.gowithu.springboot.controller;

import com.gowithu.springboot.dao.PostTemplate;
import com.gowithu.springboot.dao.UserTemplate;
import com.gowithu.springboot.entity.Post;
import com.gowithu.springboot.entity.User;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class PostController {
    @Autowired
    private PostTemplate postTemplate;
    @Autowired
    private UserTemplate userTemplate;

    /**
     * 保存一篇帖子
     */
    @ResponseBody
    @PostMapping("/post")
    public String post(@RequestBody Map<String, Object> data) {
        Post post = new Post();
        System.out.println(data.get("Content"));
        post.setContent(data.get("Content").toString());
        post.setTitle(data.get("Title").toString());
        post.setDate(data.get("Date").toString());
        post.setPublisherName(data.get("name").toString());
        post.setPublisherId(data.get("OpenId").toString());
        // post.setPublisherAvatar(data.get("UserAvatar").toString());
        postTemplate.save(post);
        return "post";
    }

    /**
     * 通过帖子的objectId 获取该帖子详细内容
     */
    @ResponseBody
    @PostMapping("/getPost")
    public Post getPost(@RequestBody Map<String, Object> data) {
        Post post = postTemplate.findById(new ObjectId(data.get("objectId").toString()));
        // result.put("Avatar", post.getPublisherAvatar());
        return post;
    }

    /**
     * 获取数据库中保存的所有帖子因为按顺序的话是最旧的帖子再前面，所以反转一下 之前好像是返回list给小程序不行，所以要map
     * 
     * @return
     */
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
