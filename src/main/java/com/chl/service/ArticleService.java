package com.chl.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.chl.model.entity.Article;
import com.chl.model.vo.ArticleVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @description: ArticleService
 * @author: mqxu
 **/
public interface ArticleService {
    /**
     * 批量新增文章
     *
     * @param articles 文章集合
     */
    void insertArticles(List<Article> articles);


    /**
     * d查询推荐的6篇文章
     *
     * @return List<Article>
     */
    List<ArticleVo> getRecommendArticles();


    /**
     * 查询文章数据并分页
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return 返回结果
     */
    PageInfo<ArticleVo> selectByPage(int pageNum, int pageSize);


    /**
     * 根据文章id查找文章详情
     *
     * @param id 文章id
     * @return Article详情
     */
    ArticleVo getDetail(@Param(value = "id") String id);


    /**
     * 发布文章
     *
     * @param article 文章
     * @return article
     */
    Article postArticle(Article article);
}
