package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;


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
}
