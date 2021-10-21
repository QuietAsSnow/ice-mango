package com.louis.icemango.service.impl;

import com.louis.icemango.dao.SysUserMapper;
import com.louis.icemango.model.SysUser;
import com.louis.icemango.service.SysUserService;
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
}
