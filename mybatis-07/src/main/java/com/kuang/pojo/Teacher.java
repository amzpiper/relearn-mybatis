package com.kuang.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author 郭宇航
 * @date 2021/9/22
 * @apiNote
 */
@Data
public class Teacher {
    private int id;
    private String name;

    //一个老师包含多个学生
    private List<Student> students;
}
