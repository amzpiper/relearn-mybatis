package com.kuang.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 郭宇航
 * @date 2021/9/23
 * @apiNote
 */
@Data
public class Blog {

    private String id;
    private String title;
    private String author;
    private Date createTime; //属性名和字段名不一致，开启驼峰
    private int views;

}
