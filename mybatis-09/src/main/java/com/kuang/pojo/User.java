package com.kuang.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 郭宇航
 * @date 2021/9/29
 * @apiNote
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String password;
}
