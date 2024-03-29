package com.louis.icemango.admin.controller;


import com.louis.icemango.admin.model.SysLog;
import com.louis.icemango.admin.service.SysLogService;
import com.louis.icemango.core.http.HttpResult;
import com.louis.icemango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 操作日志控制器
 * @author peirj
 * @date Jan 10, 2022
 */
@RestController
@RequestMapping("log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @PostMapping(value="/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysLogService.findPage(pageRequest));
    }

    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysLog> records) {
        return HttpResult.ok(sysLogService.delete(records));
    }

}
