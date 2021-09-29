package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 郭宇航
 * @date 2021/9/29
 * @apiNote
 */
public class MyTest {

    /**
     * 测试一级缓存
     * sql走了1次
     */
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        //true
        System.out.println(user==user2);

        sqlSession.close();
    }

    /**
     * 测试一级缓存,2此查询中间增加修改操作
     * sql走了2次
     */
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        //增删改操作
        User usera = new User();
        usera.setId(2);
        usera.setName("bbbbbb");
        usera.setPassword("bbbbbbb");
        //mapper.updateUser(usera);

        //手动清理缓存
        //sqlSession.clearCache();

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        //false
        System.out.println(user==user2);

        sqlSession.close();
    }

    /**
     * 测试二级缓存,2次查询使用2个sqlSession
     * sql走了1次
     */
    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        sqlSession2.close();

        //true
        System.out.println(user==user2);
    }

    /**
     * 测试查询顺序
     */
    @Test
    public void test4() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("查数据库，sqlSession关闭，放入二级缓存");
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();
        System.out.println("=============================================");

        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        System.out.println("查二级缓存");
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        System.out.println("=============================================");

        System.out.println("二级一级缓存没有，查数据库，放入一级缓存");
        User user3 = mapper2.queryUserById(2);
        System.out.println(user3);
        System.out.println("=============================================");

        System.out.println("查二级缓存没有，查一级缓存");
        User user4 = mapper2.queryUserById(2);
        System.out.println(user4);
        System.out.println("=============================================");

        sqlSession2.close();
    }
}
