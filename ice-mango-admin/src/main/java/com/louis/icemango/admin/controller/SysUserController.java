package com.louis.icemango.admin.controller;

import com.louis.icemango.admin.model.SysUser;
import com.louis.icemango.admin.service.SysUserService;
import com.louis.icemango.core.http.HttpResult;
import com.louis.icemango.core.page.PageRequest;
import com.louis.icemango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest){
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }
}
