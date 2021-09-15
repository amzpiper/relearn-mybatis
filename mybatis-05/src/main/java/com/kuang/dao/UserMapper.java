package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 郭宇航
 * @date ${DATE}
 * @apiNote
 */
public interface UserMapper {
    /**
     * 获取全部用户
     * @return List<User>
     */
    @Select("select * from user")
    public List<User> getUserList();

    /**
     * 查询by id
     * 方法存在多个参数时，所有的参数前面都要加@Param
     * @return User
     */
    @Select("select * from user where id = #{id} and name = #{name}")
    public User getUserById(@Param("id") int id,@Param("name") String name);

    /**
     * 这个地方只能写实体类属性名
     * @param user
     * @return
     */
    @Insert("insert into user(id,name,password) values (#{id},#{name},#{password})")
    public int addUser(User user);

    /**
     * 修改User
     * @return
     */
    @Update("update user set name = #{name},password = #{password} where id = #{id}")
    public int updateUser(User user);

    /**
     * 删除User
     * @return
     */
    @Delete("delete from user where id = #{id}")
    public int deleteUser(@Param("id") int id);
}
