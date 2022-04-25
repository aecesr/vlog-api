package com.chl.service;

import com.chl.model.entity.Tag;

import java.util.List;

/**
 * @description: 标签Service
 * @author: mqxu
 **/
public interface TagService {

    /**
     * 批量插入标签
     *
     * @param tags 标签集合
     */
    void insertTags(List<Tag> tags);

    /**
     * 查询所有标签
     *
     * @return 所有标签
     */
    List<Tag> selectAll();
}
