package com.louis.icemango.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间相关工具
 * @author peirj
 * @date Jan 11, 2022
 */
public class DateTimeUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前标准格式化日期时间
     * @param
     * @return String time
     */
    public static String getDateTime() {
        return getDateTime(new Date());
    }

    /**
     * 标准格式化日期时间
     * @param date
     * @return String time yyyy-MM-dd HH:mm:ss
     */
    public static String getDateTime(Date date) {
        return (new SimpleDateFormat(DATE_FORMAT)).format(date);
    }

}
