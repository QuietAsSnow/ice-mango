package com.louis.icemango.admin.service;

import com.louis.icemango.admin.model.SysMenu;
import com.louis.icemango.admin.model.SysRole;
import com.louis.icemango.admin.model.SysRoleMenu;
import com.louis.icemango.core.service.CurdService;

import java.util.List;

public interface SysRoleService extends CurdService<SysRole> {

    /**
     * 查询全部
     * @return
     */
    List<SysRole> findAll();

    /**
     * 查询角色菜单集合
     * @return
     */
    List<SysMenu> findRoleMenus(Long roleId);

    /**
     * 保存角色菜单
     * @param records
     * @return
     */
    int saveRoleMenus(List<SysRoleMenu> records);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    List<SysRole> findByName(String name);
}
