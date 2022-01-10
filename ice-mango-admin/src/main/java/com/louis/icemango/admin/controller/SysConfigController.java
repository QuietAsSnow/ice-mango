package com.louis.icemango.admin.controller;

import com.louis.icemango.admin.model.SysConfig;
import com.louis.icemango.admin.service.SysConfigService;
import com.louis.icemango.core.http.HttpResult;
import com.louis.icemango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 系统配置控制器
 * @author peirj
 * @date Jan 10, 2022
 */
@RestController
@RequestMapping(value = "/config")
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    @PostMapping(value="/save")
    public HttpResult save(@RequestBody SysConfig record) {
        return HttpResult.ok(sysConfigService.save(record));
    }

    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysConfig> records) {
        return HttpResult.ok(sysConfigService.delete(records));
    }

    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysConfigService.findPage(pageRequest));
    }

    @GetMapping(value="/findByLable")
    public HttpResult findByLable(@RequestParam String lable) {
        return HttpResult.ok(sysConfigService.findByLable(lable));
    }

}
