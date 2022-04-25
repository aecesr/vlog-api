package com.chl.task;

import com.chl.model.entity.Tag;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @description: 爬取Tag数据的任务线程
 * @author: mqxu
 **/
@Component
@Slf4j
public class TagTask implements Callable<List<Tag>> {
    @Override
    public List<Tag> call() throws Exception {
        //页面文档对象
        Document document = null;
        List<Tag> tagList = new ArrayList<>(100);
        try {
            //与目标页面建立连接
            document = Jsoup.connect("https://godweiyang.com/tags/").get();
        } catch (IOException e) {
            log.error("连接失败");
        }
        assert document != null;
        //取得包含了所有标签的div，注意因为是根据class寻找，所以返回值是个集合
        Elements tagChips = document.getElementsByClass("tag-chips");
        //我们需要get(0),然后再获取其所有孩子结点，也就是所有的a标记
        Elements tags = tagChips.get(0).children();
        //遍历所有a标记
        tags.forEach(tagNode -> {
            //通过取结点属性的方法，得到 "博客: 4"这样的结果
            String title = tagNode.attr("title");
            //分割一下得到：之前的内容
            title = title.split(":")[0];
            //得到a的第一个孩子结点，也就是span元素，从中获得颜色
            Element span = tagNode.child(0);
            //得到"background-color: #F9EBEA;"这样的结果
            String styleContent = span.attr("style");
            //再取子串得到颜色的值:#F9EBEA
            String color = styleContent.substring(styleContent.indexOf("#"), styleContent.length() - 1);
            //构建Tag对象
            Tag tag = Tag.builder().tagName(title).tagColor(color).build();
            //加入结果集合
            tagList.add(tag);
        });
        return tagList;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        TagTask tt = new TagTask();
        Future<List<Tag>> future = executor.submit(tt);
        List<Tag> tags = future.get();
        tags.forEach(tag -> System.out.println(tag.getTagName() + "," + tag.getTagColor()));
    }
}
