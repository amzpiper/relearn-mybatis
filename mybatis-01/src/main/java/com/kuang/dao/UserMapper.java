package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

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
     * 获取全部用户
     * @return
     */
    public List<User> getUserListLike(String value);

    /**
     * 查询by id
     *
     * @return
     */
    public User getUserById(int id);

    /**
     * 查询by id
     *
     * @return
     */
    public User getUserById2(Map<String,Object> map);

    /**
     * inset map,万能的map
     * 好处：不需要知道数据库有什么
     * @return
     */
    public int addUser2(Map<String,Object> map);

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
