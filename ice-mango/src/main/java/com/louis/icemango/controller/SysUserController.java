package com.louis.icemango.controller;

import com.louis.icemango.model.SysUser;
import com.louis.icemango.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "/selectAll")
    public List<SysUser> selectAll(){
        return sysUserService.selectAll();
    }
}
