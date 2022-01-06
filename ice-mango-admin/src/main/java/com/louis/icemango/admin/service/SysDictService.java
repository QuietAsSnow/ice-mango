package com.louis.icemango.admin.service;

import com.louis.icemango.admin.model.SysDict;
import com.louis.icemango.core.service.CurdService;

import java.util.List;

/**
 * 字典管理
 */
public interface SysDictService extends CurdService<SysDict> {

    /**
     * 根据名称查询
     * @param label
     * @return
     */
    List<SysDict> findByLabel(String label);

}
