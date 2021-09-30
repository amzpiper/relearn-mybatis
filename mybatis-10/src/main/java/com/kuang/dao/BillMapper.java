package com.kuang.dao;

import com.kuang.pojo.Bill;
import com.kuang.pojo.BillPro;
import com.kuang.pojo.Provider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BillMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);
    
    @Select("select proname from smbms_provider")
    List<String> selectProNameByAll();
    
    @Select("select id,proname from smbms_provider")
    List<Provider> selectProNameAndIdByAll();
    
    List<BillPro> selectByPageAll(@Param("productname")String productname, @Param("proname")String proname, @Param("ispayment")String ispayment);

}