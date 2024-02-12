package com.walle.webnoteadmin.service.impl;

import com.walle.webnoteadmin.entity.Tag;
import com.walle.webnoteadmin.mapper.TagMapper;
import com.walle.webnoteadmin.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;


    @Override
    public List<Tag> findAllTag() {
        return tagMapper.findAllTag();
    }
}
