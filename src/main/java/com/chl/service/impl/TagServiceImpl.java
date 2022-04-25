package com.chl.service.impl;

import com.chl.mapper.TagMapper;
import com.chl.model.entity.Tag;
import com.chl.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: mqxu
 **/
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public void insertTags(List<Tag> tags) {
        tagMapper.insertTags(tags);
    }

    @Override
    public List<Tag> selectAll() {
        return tagMapper.selectAll();
    }
}
