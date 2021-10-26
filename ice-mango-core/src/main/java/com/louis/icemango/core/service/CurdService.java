package com.louis.icemango.core.service;

import com.louis.icemango.core.page.PageRequest;
import com.louis.icemango.core.page.PageResult;

import java.util.List;

/**
 *  通用业务接口定义
 */
public interface CurdService<T> {

    /**
     * 保存
     * @param record
     * @return
     */
    int save(T record);

    /**
     * 删除
     * @param record
     * @return
     */
    int delete(T record);

    /**
     * 批量删除
     * @param records
     * @return
     */
    int delete(List<T> records);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 分页查询：
     *   这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象。
     *   如Mybatis或JPA的分页对象从而避免因为替换ORM框架而导致服务层，
     *   控制层的分页接口也有需要变动的情况，替换ORM也不会影响服务层
     *   起到了解耦的作用。
     *
     * @param pageRequest 自定义，统一的分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    PageResult findPage(PageRequest pageRequest);
}
