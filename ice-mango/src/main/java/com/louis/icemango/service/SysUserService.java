package com.louis.icemango.service;

import com.louis.icemango.model.SysUser;

import java.util.List;

public interface SysUserService {

    /**
     * 查询所有用户信息
     * @return
     */
    List<SysUser> selectAll();
}
