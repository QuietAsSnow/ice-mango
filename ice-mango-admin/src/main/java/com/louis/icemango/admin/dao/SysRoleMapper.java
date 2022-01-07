package com.louis.icemango.admin.dao;

import com.louis.icemango.admin.model.SysRole;
import com.louis.icemango.admin.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);

    List<SysRole> findPage();

    List<SysRole> findAll();

    List<SysRole> findPageByName(@Param(value="name") String name);

    List<SysRole> findByName(@Param(value="name") String name);
}