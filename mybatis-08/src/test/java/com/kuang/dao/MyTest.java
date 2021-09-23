package com.kuang.dao;

import com.kuang.pojo.Blog;
import com.kuang.utils.IDutils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 郭宇航
 * @date 2021/9/23
 * @apiNote
 */
public class MyTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getUUIDString());
        blog.setTitle("mybatis-tools");
        blog.setAuthor("kuang");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IDutils.getUUIDString());
        blog.setTitle("spring-tools");
        blog.setAuthor("shen");
        blog.setCreateTime(new Date());
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        //查询所有
        Map map = new HashMap<>();
        List<Blog> blogs = mapper.queryBlog(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("---------------------------------------");

        //查询title
        map.put("title", "mybatis-tools");
        blogs = mapper.queryBlog(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("---------------------------------------");


        //查询author
        map.remove("title");
        map.put("author", "kuang");
        blogs = mapper.queryBlog(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("---------------------------------------");

        sqlSession.close();
    }

    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        //查精选的书
        Map map = new HashMap<>();
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("---------------------------------------");

        //查询title
        map.put("title", "mybatis-tools");
        blogs = mapper.queryBlog(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("---------------------------------------");


        //查询author
        map.remove("title");
        map.put("author", "kuang");
        blogs = mapper.queryBlog(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        System.out.println("---------------------------------------");

        sqlSession.close();
    }

    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        //修改id=1的title
        Map map = new HashMap<>();
        map.put("id", "1");
        map.put("title", "mybatis-tools2");
        mapper.updateBlog(map);
        System.out.println("---------------------------------------");

        //修改id=1的author
        map.remove("title");
        map.put("author", "kuang2");
        mapper.updateBlog(map);
        System.out.println("---------------------------------------");

        sqlSession.close();
    }
}
