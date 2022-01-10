package com.louis.icemango.admin.controller;

import com.louis.icemango.admin.model.SysDept;
import com.louis.icemango.admin.service.SysDeptService;
import com.louis.icemango.core.http.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @PostMapping(value="/save")
    public HttpResult save(@RequestBody SysDept record) {
        return HttpResult.ok(sysDeptService.save(record));
    }

    @PostMapping(value="/delete")
    public HttpResult delete(@RequestBody List<SysDept> records) {
        return HttpResult.ok(sysDeptService.delete(records));
    }

    @GetMapping(value="/findTree")
    public HttpResult findTree() {
        return HttpResult.ok(sysDeptService.findTree());
    }

}
