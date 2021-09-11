package com.kuang.dao;

import com.kuang.pojo.User;

/**
 * @author 郭宇航
 * @date ${DATE}
 * @apiNote
 */
public interface UserMapper {

    /**
     * 查询by id
     *
     * @return
     */
    public User getUserById(int id);

}
