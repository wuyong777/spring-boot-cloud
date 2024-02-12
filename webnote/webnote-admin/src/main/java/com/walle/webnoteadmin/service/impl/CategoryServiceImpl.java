package com.walle.webnoteadmin.service.impl;

import com.walle.webnoteadmin.entity.Category;
import com.walle.webnoteadmin.mapper.CategoryMapper;
import com.walle.webnoteadmin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public List<Category> findAllCategory() {
        return categoryMapper.findAllCategory();
    }
}
