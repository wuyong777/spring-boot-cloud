package com.walle.webnoteadmin.mapper;

import com.walle.webnoteadmin.entity.Article;
import com.walle.webnoteadmin.entity.Category;
import com.walle.webnoteadmin.entity.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagMapper {
    @Select("select * from t_tag")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time"),
            @Result(property = "articles",javaType = List.class,column = "id",
            many = @Many(select = "com.walle.webnoteadmin.mapper.ArticleMapper.getArticlesByTid"))
    })
     List<Tag> findAllTag();

    @Select("select * from t_tag where id in(select tag_id from t_article_tag where article_id=#{aid})")
    List<Tag> getTagsByAid(int aid);
}
