package com.louis.icemango.core.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.louis.icemango.common.utils.ReflectionUtils;

import java.util.List;


/**
 *  MyBatis 分页查询助手
 */
public class MybatisPageHelper {

    public static final String findPage = "findPage";

    /**
     * 分页查询, 约定查询方法名为 “findPage”
     *
     * note:
     *   没有传入方法对象参数 args，分页都为空参方法
     *
     * @param pageRequest
     * @param mapper
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest, Object mapper){
        return findPage(pageRequest, mapper, findPage);
    }

    /**
     * 调用分页插件进行分页查询
     *
     *  note:
     *    "rawtypes"，这个参数是告诉编译器不用提示使用基本类型参数时相关的警告信息。
     *    一般是在通过传参调用某个方法的时候进行标识。
     *
     * @param pageRequest 分页请求
     * @param mapper Dao对象，Mybatis的 Mapper
     * @param queryMethodName 要分页的查询方法名
     * @param args 方法参数
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static PageResult findPage(PageRequest pageRequest, Object mapper,
                                       String queryMethodName, Object... args){
        //设置分页参数
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        //利用反射调用查询方法
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        //查询出来的result一定是list集合
        return getPageResult(pageRequest, new PageInfo((List)result));
    }

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    private static PageResult getPageResult(PageRequest pageRequest, PageInfo pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
