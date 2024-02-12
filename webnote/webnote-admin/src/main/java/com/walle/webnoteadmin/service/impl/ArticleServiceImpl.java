package com.walle.webnoteadmin.service.impl;

import com.walle.webnoteadmin.entity.Article;
import com.walle.webnoteadmin.mapper.ArticleMapper;
import com.walle.webnoteadmin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> findAllArticle() {
        return articleMapper.findAllArticle();
    }
}
