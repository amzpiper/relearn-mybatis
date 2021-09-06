package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class UserDaoTest {

    @Test
    public void test() {
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //第二步：面向接口编程,获取UserDao,执行SQL
        //方式1
        List<User> userList = sqlSession.getMapper(UserDao.class).getUserList();
        for (User user : userList) {
            System.out.println(user.toString());
        }
        //方式2不推荐
        userList = sqlSession.selectList("com.kuang.dao.UserDao.getUserList");
        for (User user : userList) {
            System.out.println(user.toString());
        }

        //关闭sqlSession
        sqlSession.close();

    }
}
