package com.louis.icemango.admin.service;

import com.louis.icemango.admin.model.SysConfig;
import com.louis.icemango.core.service.CurdService;

import java.util.List;

public interface SysConfigService extends CurdService<SysConfig> {

    /**
     * 根据名称查询
     * @param lable
     * @return
     */
    List<SysConfig> findByLable(String lable);

}
