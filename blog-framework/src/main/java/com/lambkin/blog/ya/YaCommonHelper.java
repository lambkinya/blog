package com.lambkin.blog.ya;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * <p></p>
 *
 * @author lambkinya
 * @since 2023-09-15 16:22:42
 */
public class YaCommonHelper {


    /**
     * 生成OSS文件上传路径--yyyy/MM/dd/coderNo-uuid.jpg
     * @param fileName 要上传的文件原始名称
     * @return yyyy/MM/dd/coderNo-uuid.jpg
     */
    public static String generateFilePath(String fileName){
        // 根据日期生成路径   2023/9/15/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");
        String datePath = sdf.format(new Date());

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");

        // 后缀和文件后缀一致
        int index = fileName.lastIndexOf(".");
        // test.jpg -> .jpg
        String fileType = fileName.substring(index);
        String coderNo = fileName.substring(0, index);
        fileName = coderNo + "-" + uuid + fileType;
        return datePath + fileName;
    }

}
