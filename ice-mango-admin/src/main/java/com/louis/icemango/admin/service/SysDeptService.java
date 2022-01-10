package com.louis.icemango.admin.service;

import com.louis.icemango.admin.model.SysDept;
import com.louis.icemango.core.service.CurdService;

import java.util.List;

/**
 * 机构管理
 * @author peirj
 * @date Jan 10, 2022
 */
public interface SysDeptService extends CurdService<SysDept> {

    /**
     * 查询机构树
     * @param
     * @return
     */
    List<SysDept> findTree();

}
