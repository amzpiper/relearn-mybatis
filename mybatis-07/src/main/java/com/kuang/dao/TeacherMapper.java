package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * @author 郭宇航
 * @date 2021/9/22
 * @apiNote
 */
public interface TeacherMapper {

    Teacher getTeacher(@Param("tid") Integer id);

}
