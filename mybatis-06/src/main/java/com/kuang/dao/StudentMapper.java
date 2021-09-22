package com.kuang.dao;

import com.kuang.pojo.Student;

import java.util.List;

/**
 * @author 郭宇航
 * @date 2021/9/22
 * @apiNote
 */
public interface StudentMapper {

    //查询所有学生信息以及对应的老师
    //方式一
    public List<Student> getStudent();

    //方式二
    public List<Student> getStudent2();

}
