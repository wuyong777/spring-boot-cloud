package com.walle.webnoteadmin.controller;

import com.walle.webnoteadmin.entity.Article;
import com.walle.webnoteadmin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/findAllArticle")
    public List<Article> findAllArticle() {
        return articleService.findAllArticle();
    }
}
