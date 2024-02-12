package com.walle.webnoteadmin.mapper;

import com.walle.webnoteadmin.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from t_category")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "articles",javaType = List.class,column = "id",
            many = @Many(select = "com.walle.webnoteadmin.mapper.ArticleMapper.getArticlesByCid"))
    })
    List<Category> findAllCategory();

    @Select("select * from t_category where id=#{id}")
    Category getCategoryById(int id);
}
