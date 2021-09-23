package com.kuang.dao;

import com.kuang.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author 郭宇航
 * @date 2021/9/23
 * @apiNote
 */
public interface BlogMapper {

    //插入博客
    int addBlog(Blog blog);

    //查询博客，传title，查指定书；传作者，查作者所有书；不传时，查所有书
    List<Blog> queryBlog(Map map);

    //传title，查指定书;传作者，查作者所有书;不传时，查精选的书
    List<Blog> queryBlogChoose(Map map);

    //更新博客,
    int updateBlog(Map map);
}
