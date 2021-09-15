package com.kuang.pojo;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * @author 郭宇航
 */
@Alias("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String password;
}
