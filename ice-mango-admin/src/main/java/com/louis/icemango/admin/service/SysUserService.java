package com.louis.icemango.admin.service;

import com.louis.icemango.admin.model.SysUser;
import com.louis.icemango.admin.model.SysUserRole;
import com.louis.icemango.core.page.PageRequest;
import com.louis.icemango.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

public interface SysUserService extends CurdService<SysUser>{

    /**
     * 查询所有用户信息
     * @return List<SysUser>
     */
    List<SysUser> selectAll();

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return SysUser
     */
    SysUser findByName(String username);

    /**
     * 查找用户的角色集合
     * @param userId
     * @return List<SysUserRole>
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 查找用户的菜单权限标识集合
     * @param userName
     * @return Set<String>
     */
    Set<String> findPermissions(String userName);

    /**
     * 导出用户信息Excel报表
     * @param pageRequest
     * @return File
     */
    File createUserExcelFile(PageRequest pageRequest);

}
