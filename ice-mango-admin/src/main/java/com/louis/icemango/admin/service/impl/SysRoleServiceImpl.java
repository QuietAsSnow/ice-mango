package com.louis.icemango.admin.service.impl;

import com.louis.icemango.admin.constant.SysConstants;
import com.louis.icemango.admin.dao.SysMenuMapper;
import com.louis.icemango.admin.dao.SysRoleMapper;
import com.louis.icemango.admin.dao.SysRoleMenuMapper;
import com.louis.icemango.admin.model.SysMenu;
import com.louis.icemango.admin.model.SysRole;
import com.louis.icemango.admin.model.SysRoleMenu;
import com.louis.icemango.admin.service.SysRoleService;
import com.louis.icemango.core.page.MybatisPageHelper;
import com.louis.icemango.core.page.PageRequest;
import com.louis.icemango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.findAll();
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
            // 如果是超级管理员，返回全部
            return sysMenuMapper.findAll();
        }
        return sysMenuMapper.findRoleMenus(roleId);
    }

    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if(records == null || records.isEmpty()) {
            return 1;
        }
        Long roleId = records.get(0).getRoleId();
        sysRoleMenuMapper.deleteByRoleId(roleId);
        for(SysRoleMenu record:records) {
            sysRoleMenuMapper.insertSelective(record);
        }
        return 1;    }

    @Override
    public List<SysRole> findByName(String name) {
        return sysRoleMapper.findByName(name);
    }

    @Override
    public int save(SysRole record) {
        if(record.getId() == null || record.getId() == 0) {
            return sysRoleMapper.insertSelective(record);
        }
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysRole> records) {
        for(SysRole record: records){
            sysRoleMapper.deleteByPrimaryKey(record.getId());
        }
        return 1;
    }

    @Override
    public SysRole findById(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("name");
        if(label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysRoleMapper, "findPageByName", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysRoleMapper);
    }

}
