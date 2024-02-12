package com.walle.webnoteadmin.mapper;

import com.walle.webnoteadmin.entity.Article;
import com.walle.webnoteadmin.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("select * from t_article")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "category",javaType = Category.class,column = "category_id",
            one = @One(select = "com.walle.webnoteadmin.mapper.CategoryMapper.getCategoryById")),
            @Result(property = "tags",javaType = List.class,column = "id",
                    many = @Many(select = "com.walle.webnoteadmin.mapper.TagMapper.getTagsByAid"))
    })
    List<Article> findAllArticle();

    @Select("select * from t_article where category_id=#{cid}")
    List<Article> getArticlesByCid(int cid);

    @Select("select * from t_article where id in(select article_id from t_article_tag where tag_id=#{tid})")
    List<Article> getArticlesByTid(int tid);
}
