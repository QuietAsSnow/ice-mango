package com.louis.icemango.common.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 文件相关操作
 * @author peirj
 * @date Jan 11, 2022
 */
public class FileUtils {

    /**
     * 下载文件
     * @param response
     * @param file
     * @param newFileName
     */
    public static void downloadFile(HttpServletResponse response, File file, String newFileName) {
        try {
            response.setHeader("Content-Disposition", "attachment; filename=" + new String(newFileName.getBytes("ISO-8859-1"), "UTF-8"));
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            InputStream is = new FileInputStream(file.getAbsolutePath());
            BufferedInputStream bis = new BufferedInputStream(is);
            int length = 0;
            byte[] temp = new byte[1 * 1024 * 10];
            //获取数据到输入流
            while ((length = bis.read(temp)) != -1) {
                bos.write(temp, 0, length);
            }
            //刷新输出流,强行将缓冲区的内容写入输出流
            bos.flush();
            //关闭输入流
            bis.close();
            //关闭输出流
            bos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
