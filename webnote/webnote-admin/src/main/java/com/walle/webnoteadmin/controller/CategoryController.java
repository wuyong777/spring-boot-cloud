package com.walle.webnoteadmin.controller;

import com.walle.webnoteadmin.entity.Category;
import com.walle.webnoteadmin.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/findAllCategory")
    public List<Category> findAllCategory() {
        return categoryService.findAllCategory();
    }


}
