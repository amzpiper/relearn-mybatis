package com.kuang.pojo;

import lombok.Data;

/**
 * @author 郭宇航
 * @date 2021/9/22
 * @apiNote
 */
@Data
public class Student {

    private int id;
    private String name;

    //学生要关联1个老师
    private Teacher teacher;
}
