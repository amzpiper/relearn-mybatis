package com.kuang.dao;

import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 郭宇航
 * @date 2021/9/22
 * @apiNote
 */
public class MyTest {

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher(1);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        //Teacher(id=1, name=missLi, students=[Student(id=1, name=ming, tid=1), Student(id=2, name=hong, tid=1), Student(id=3, name=zhang, tid=1), Student(id=4, name=li, tid=1), Student(id=5, name=wang, tid=1)])
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teachers = mapper.getTeacher2(1);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        //Teacher(id=1, name=missLi, students=[Student(id=1, name=ming, tid=1), Student(id=2, name=hong, tid=1), Student(id=3, name=zhang, tid=1), Student(id=4, name=li, tid=1), Student(id=5, name=wang, tid=1)])
    }

}
