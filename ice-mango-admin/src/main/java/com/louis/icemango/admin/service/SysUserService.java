package com.louis.icemango.admin.service;

import com.louis.icemango.admin.model.SysUser;
import com.louis.icemango.core.page.PageRequest;
import com.louis.icemango.core.page.PageResult;
import com.louis.icemango.core.service.CurdService;

import java.util.List;

public interface SysUserService{

    /**
     * 查询所有用户信息
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 查找所有用户并分页
     * @return
     */
    PageResult findPage(PageRequest pageRequest);
}
