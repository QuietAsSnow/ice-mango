package com.louis.icemango.admin.service.impl;

import com.louis.icemango.admin.dao.SysUserMapper;
import com.louis.icemango.admin.service.SysUserService;
import com.louis.icemango.admin.model.SysUser;
import com.louis.icemango.core.page.MybatisPageHelper;
import com.louis.icemango.core.page.PageRequest;
import com.louis.icemango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> selectAll() {
        return sysUserMapper.selectAll();
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysUserMapper);
    }
}
