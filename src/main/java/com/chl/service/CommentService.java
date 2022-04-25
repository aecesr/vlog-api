package com.chl.service;

import com.chl.model.entity.Comment;
import com.chl.model.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: mqxu
 **/
public interface CommentService {
    /**
     * 根据文章id查询评论
     *
     * @param articleId 文章id
     * @return 所有评论
     */
    List<CommentVo> selectByArticleId(String articleId);

    /**
     * 新增评论
     *
     * @param comment 新增评论对象
     * @return 所有评论视图列表
     */
    List<CommentVo> addComment(@Param("comment") Comment comment);
}
