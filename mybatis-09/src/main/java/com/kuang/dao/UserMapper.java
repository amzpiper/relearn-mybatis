package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 郭宇航
 * @date 2021/9/29
 * @apiNote
 */
public interface UserMapper {

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User queryUserById(@Param("id") int id);

    /**
     * 修改用户
     */
    void updateUser(User user);
}
