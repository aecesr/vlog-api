package com.chl.mapper;

import com.chl.model.entity.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description: 标签Mapper
 * @author: mqxu
 **/
public interface TagMapper {
    /**
     * 批量插入tag
     *
     * @param tagList 标签集合
     * @return int
     */
    @Insert({
            "<script>",
            "INSERT INTO t_tag(tag_name, tag_color) VALUES ",
            "<foreach collection='tagList' item='item' index='index' separator=','>",
            "(#{item.tagName}, #{item.tagColor})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertTags(@Param(value = "tagList") List<Tag> tagList);

    /**
     * 查询所有标签
     *
     * @return List<Tag>
     */
    @Select("SELECT * FROM t_tag ")
    List<Tag> selectAll();
}
