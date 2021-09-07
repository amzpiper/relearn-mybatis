package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

/**
 * @author 郭宇航
 */
public interface UserMapper {
    /**
     * 获取全部用户
     * @return
     */
    public List<User> getUserList();

    /**
     *
     * @return
     */
    public User getUserById(int id);

    /**
     *
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 修改User
     * @return
     */
    public int updateUser(User user);

    /**
     * 删除User
     * @return
     */
    public int deleteUser(int id);
}
