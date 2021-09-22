package com.kuang.dao;

import com.github.pagehelper.PageHelper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UserMapperTest {

    @Test
    public void test1() {
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //第二步：面向接口编程,获取UserDao,执行SQL
        //方式1
        List<User> userList = sqlSession.getMapper(UserMapper.class).getUserList();
        for (User user : userList) {
            System.out.println(user.toString());
        }

        //关闭sqlSession
        sqlSession.close();
    }

    static Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void testLog4j() {
        logger.info("info:进入testLog4j方法");
        logger.debug("debug:进入调试语句");
        logger.error("error:trycatch紧急");
    }

    @Test
    public void test2() {
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //第二步：面向接口编程,获取UserDao,执行SQL
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 0);
        map.put("pageSize",2);

        List<User> userList = sqlSession.getMapper(UserMapper.class).getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user.toString());
        }

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void test3() {
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //第二步：通过java代码实现分页
        //RowBouns
        RowBounds rowBounds = new RowBounds(1, 2);

        List<User> userList = sqlSession.selectList("com.com.kuang.com.kuang.dao.UserMapper.getUserByRowBounds",User.class,rowBounds);
        for (User user : userList) {
            System.out.println(user.toString());
        }

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void test4() {
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //第二步：通过PageHelper实现分页
        PageHelper.startPage(1, 2);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user.toString());
        }

        //关闭sqlSession
        sqlSession.close();
    }
}
