package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class UserMapperTest {

    /**
     * 测试查询通过id
     */
    @Test
    public void test() {
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //第二步：面向接口编程,获取UserDao,执行SQL
        User user = sqlSession.getMapper(UserMapper.class).getUserById(1);
        System.out.println(user.toString());

        //关闭sqlSession
        sqlSession.close();
    }

}
