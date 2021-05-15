package com.ac.comehome.client;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * @program: comehome
 * @description:
 * @author: ErFeng_V
 * @create: 2021-04-17 20:15
 */
public interface FileClient {

    /**
     * 上传文件
     * @param file
     * @return
     */
    public String uplodFile(MultipartFile file);

    public String uplodFile(InputStream inputStream, Long size, String type);

    /**
     * 删除文件
     * @param fullPath
     */
    public void deleteFile(String fullPath);
}
