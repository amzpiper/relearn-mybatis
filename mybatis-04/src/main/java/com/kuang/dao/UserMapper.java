package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author 郭宇航
 * @date ${DATE}
 * @apiNote
 */
public interface UserMapper {
    /**
     * 获取全部用户
     * @return
     */
    public List<User> getUserList();

    /**
     * 查询by id
     *
     * @return
     */
    public User getUserById(int id);

    /**
     *
     * @param map
     * @return
     */
    public List<User> getUserByLimit(Map<String,Integer> map);

    /**
     * RowBounds
     * @return
     */
    public List<User> getUserByRowBounds();

    /**
     * PageHelper
     * @return
     */
    public List<User> getUserByPageHelper();

}
