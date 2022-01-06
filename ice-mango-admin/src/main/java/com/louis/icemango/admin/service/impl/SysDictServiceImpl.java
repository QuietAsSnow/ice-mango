package com.louis.icemango.admin.service.impl;

import com.louis.icemango.admin.dao.SysDictMapper;
import com.louis.icemango.admin.model.SysDict;
import com.louis.icemango.admin.service.SysDictService;
import com.louis.icemango.core.page.PageRequest;
import com.louis.icemango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> findByLabel(String label) {
        return null;
    }

    @Override
    public int save(SysDict record) {
        if(record.getId() == null ||  record.getId() == 0){
//            return sysDictMapper.insertSelective(record);
        }
        return 0;
    }

    @Override
    public int delete(SysDict record) {
        return 0;
    }

    @Override
    public int delete(List<SysDict> records) {
        return 0;
    }

    @Override
    public SysDict findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return null;
    }

}
