package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 郭宇航
 * @date 2021/9/22
 * @apiNote
 */
public interface TeacherMapper {

    //获取所有老师
    //List<Teacher> getTeacher();

    //方式一、按结果嵌套查询，获取指定老师和所有老师关联的学生
    List<Teacher> getTeacher(@Param("tid") int id);

    //方式二、按子查询，获取指定老师和所有老师关联的学生
    List<Teacher> getTeacher2(@Param("tid") int id);

}
