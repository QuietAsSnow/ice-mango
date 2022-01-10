package com.louis.icemango.admin.service;

import com.louis.icemango.admin.model.SysUser;
import com.louis.icemango.admin.model.SysUserRole;
import com.louis.icemango.core.page.PageRequest;
import com.louis.icemango.core.page.PageResult;
import com.louis.icemango.core.service.CurdService;

import java.util.List;
import java.util.Set;

public interface SysUserService extends CurdService<SysUser>{

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

    SysUser findByName(String username);

    /**
     * 查找用户的角色集合
     * @param userId
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

}
