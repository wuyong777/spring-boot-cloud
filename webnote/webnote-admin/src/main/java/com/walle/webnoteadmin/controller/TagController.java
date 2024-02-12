package com.walle.webnoteadmin.controller;

import com.walle.webnoteadmin.entity.Tag;
import com.walle.webnoteadmin.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/findAllTag")
    public List<Tag> findAllTag() {
        return tagService.findAllTag();
    }
}

