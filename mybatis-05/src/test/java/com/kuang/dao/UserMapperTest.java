package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class UserMapperTest {

    @Test
    public void test1() {
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //第二步：面向接口编程,获取UserDao,执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user.toString());
        }

        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 测试查询通过id
     */
    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        User user = sqlSession.getMapper(UserMapper.class).getUserById(1,"guoyuhang");
        System.out.println(user.toString());

        sqlSession.close();
    }

    /**
     * 插入
     */
    @Test
    public void test3() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        User user = new User(4,"root","1234");
        int res = sqlSession.getMapper(UserMapper.class).addUser(user);
        if (res>0){
            System.out.println("插入成功");
        }

        //提交事务,openSession已经自动提交事务了
        //sqlSession.commit();
        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 修改
     */
    @Test
    public void test4() {
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        User user = new User(4,"root","root");
        int res = sqlSession.getMapper(UserMapper.class).updateUser(user);
        if (res>0){
            System.out.println("修改成功");
        }

        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 删除
     */
    @Test
    public void test5() {
        //第一步：获得sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //第二步：面向接口编程,获取UserDao,执行SQL
        int res = sqlSession.getMapper(UserMapper.class).deleteUser(4);
        if (res>0){
            System.out.println("删除成功");
        }

        //关闭sqlSession
        sqlSession.close();
    }
}
