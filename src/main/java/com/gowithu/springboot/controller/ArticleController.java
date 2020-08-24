package com.gowithu.springboot.controller;

import com.gowithu.springboot.dao.ArticleTemplate;
import com.gowithu.springboot.entity.Article;
import org.springframework.data.mongodb.util.BsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cjk
 */
@RestController
public class ArticleController {

    @Resource
    private ArticleTemplate articleTemplate;

    @RequestMapping("/getArticle")
    public List<Article> getArticles() {
        List<Article> articleList = articleTemplate.findArticles();
        return articleList;
    }

}
