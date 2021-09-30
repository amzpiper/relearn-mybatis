package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.pojo.UserRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Select("select * from smbms_user where usercode = #{userCode}")
    User SelectByUserCode(String userCode);
    
    //@Select("select u.*,r.rolename from smbms_user u,smbms_role r where u.userrole=r.id")
    List<UserRole> selectByPageAll(@Param("username")String username, @Param("rolename")String rolename);
   
    /**
     * 密码修改
     * @param userpassword
     * @param id
     * @return
     */
    @Update("update smbms_user set userpassword=#{userpassword} where id=#{id}")
    int updatepwd(@Param("userpassword")String userpassword,@Param("id")Long id);
}