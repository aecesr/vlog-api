package com.chl.mapper;

import com.github.pagehelper.Page;
import com.chl.model.entity.Article;
import com.chl.model.vo.ArticleVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @description:
 * @author: mqxu
 **/
public interface ArticleMapper {


    /**
     * 新增文章
     *
     * @param article 入参
     */
    @Insert("INSERT INTO t_article (id,category,user_id,title,cover,summary,content,create_time,total_words,duration,page_view) " +
            "VALUES (#{article.id}, #{article.category},#{article.userId},#{article.title},#{article.cover},#{article.summary},#{article.content}," +
            "#{article.createTime},#{article.totalWords},#{article.duration},#{article.pageView})")
    void insert(@Param("article") Article article);

    /**
     * 批量插入文章
     *
     * @param articleList 文章集合
     * @return int
     */
    @Insert({"<script>",
            "INSERT INTO t_article (id,category,user_id,title,cover,summary,content,create_time,total_words,duration,page_view) VALUES ",
            "<foreach collection='articleList' item='item' index='index' separator=','>",
            "(#{item.id}, #{item.category},#{item.userId},#{item.title},#{item.cover},#{item.summary},#{item.content},#{item.createTime},#{item.totalWords},#{item.duration},#{item.pageView})",
            "</foreach>",
            "</script>"
    })
    int insertArticles(@Param(value = "articleList") List<Article> articleList);


    /**
     * 查询推荐文章
     *
     * @return List<ArticleVo>
     */
    @Select("""
            SELECT a.id,a.category,a.user_id,a.title,a.cover,a.summary,b.nickname,b.avatar
            FROM t_article a\s
            LEFT JOIN t_user b
            ON a.user_id = b.id
            ORDER BY a.page_view DESC
            LIMIT 6\s""")
    List<ArticleVo> getRecommendArticles();


    /**
     * 分页查询所有文章
     *
     * @return Page<Article>
     */
    @Select("SELECT a.id,a.category,a.user_id,a.title,a.cover,a.summary,a.create_time,b.nickname,b.avatar FROM t_article a " +
            "LEFT JOIN t_user b ON a.user_id = b.id  ORDER BY a.create_time DESC ")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "category", column = "category"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "summary", column = "summary"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "tagList", column = "id",
                    many = @Many(select = "com.chl.mapper.ArticleTagMapper.selectByArticleId")),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar")
    })
    Page<ArticleVo> selectAll();


    /**
     * 根据文章id查找文章详情
     *
     * @param id 文章id
     * @return Article详情
     */
    @Select("SELECT a.*,b.nickname,b.avatar FROM t_article a LEFT JOIN t_user b ON a.user_id = b.id  WHERE a.id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "category", column = "category"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "cover", column = "cover"),
            @Result(property = "content", column = "content"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "totalWords", column = "total_words"),
            @Result(property = "duration", column = "duration"),
            @Result(property = "pageView", column = "page_view"),
            @Result(property = "tagList", column = "id",
                    many = @Many(select = "com.chl.mapper.ArticleTagMapper.selectByArticleId")),
            @Result(property = "commentList", column = "id",
                    many = @Many(select = "com.chl.mapper.CommentMapper.selectByArticleId")),
            @Result(property = "nickname", column = "nickname"),
            @Result(property = "avatar", column = "avatar"),
    })
    ArticleVo getDetail(@Param(value = "id") String id);

}
