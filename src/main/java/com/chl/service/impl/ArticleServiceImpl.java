package com.chl.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.chl.mapper.ArticleMapper;
import com.chl.mapper.ArticleTagMapper;
import com.chl.model.entity.Article;
import com.chl.model.entity.ArticleTag;
import com.chl.model.vo.ArticleVo;
import com.chl.service.ArticleService;
import com.chl.util.DataUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 * @author: mqxu
 **/
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleTagMapper articleTagMapper;

    @Override
    public void insertArticles(List<Article> articles) {
        //批量插入文章
        articleMapper.insertArticles(articles);
        assert articles != null;
        articles.forEach(article -> {
            //如果文章有标签，就批量插入文章标签
            if (article.getTagList() != null) {
                articleTagMapper.insertArticleTags(article.getTagList());
            }
        });
    }



    @Override
    public List<ArticleVo> getRecommendArticles() {
        return articleMapper.getRecommendArticles();
    }


    @Override
    public PageInfo<ArticleVo> selectByPage(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单
        PageHelper.startPage(pageNum, pageSize);
        //先根据用户id查到所有数据
        Page<ArticleVo> articlePage = articleMapper.selectAll();
//        log.info("articlePage:--------------------"+articlePage);
        //将这些数据作为入参构建出PageInfo（包含了总页数，当前页码、每页数量、当前页数据list等等一堆属性和方法）
        return new PageInfo<>(articlePage);
    }

    @Override
    public ArticleVo getDetail(String id) {
        return articleMapper.getDetail(id);
    }


    @Override
    public Article postArticle(Article article) {
        //随机生成id
        article.setId(UUID.randomUUID().toString());
        //补全其他前端传递数据中缺少的内容
        article.setCover("https://picsum.photos/1920/1080?random&rand=" + Math.random());
        article.setCreateTime(LocalDateTime.now());
        article.setTotalWords(DataUtil.getTotalWords());
        article.setDuration(DataUtil.getDuration());
        article.setPageView(DataUtil.getPageView());

        System.out.println(article);
        //新增文章
        articleMapper.insert(article);
        //对应更新前端传递的标签数组中的文章id属性
        article.getTagList().forEach(tag->{
            tag.setArticleId(article.getId());
        });
        //获得文章的标签列表
//        List<ArticleTag> tagList = article.getTagList();
        ////批量插入标签
        articleTagMapper.insertArticleTags(article.getTagList());
        return article;
    }
}
