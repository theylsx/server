package com.gowithu.springboot.dao;

import com.gowithu.springboot.entity.Article;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cjk
 */
@Component
public class ArticleTemplate {

    @Resource
    private MongoTemplate mongoTemplate;

    public List<Article> findArticles() {
        List<Article> articleList = mongoTemplate.findAll(Article.class);
        return articleList;
    }

}
