package com.louis.icemango.admin.dao;

import com.louis.icemango.admin.model.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDictMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDict record);

    int insertSelective(SysDict record);

    SysDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDict record);

    int updateByPrimaryKey(SysDict record);

    /**
     * 分页查询
     */
    List<SysDict> findPage();

    /**
     * 根据标签名称查询
     * @param label
     */
    List<SysDict> findPageByLabel(@Param(value="label") String label);

    /**
     * 根据标签名称分页查询
     * @param label
     */
    List<SysDict> findByLabel(@Param(value="label") String label);
}