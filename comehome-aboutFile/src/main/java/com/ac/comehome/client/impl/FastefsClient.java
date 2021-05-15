package com.ac.comehome.client.impl;

import com.ac.comehome.client.FileClient;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;


/**
 *fastdfs方案
 * @author 帅气的二峰
 */
@Service
public class FastefsClient implements FileClient {

    /**
     *  storage客户端接口
     */
    protected FastFileStorageClient storageClient;

    @Autowired
    public void setStorageClient(FastFileStorageClient storageClient) {
        this.storageClient = storageClient;
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @Override
    public String uplodFile(MultipartFile file) {
        String fileType = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
        StorePath path = null;
        try {
            path = storageClient.uploadFile(file.getInputStream(), file.getSize(), fileType, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (path != null) {
            return path.getFullPath();
        } else {
            return null;
        }
    }

    /**
     * 上传文件
     * @param inputStream
     * @param size
     * @param type
     * @return
     */
    @Override
    public String uplodFile(InputStream inputStream, Long size, String type) {
        StorePath path = null;
        try {
            path = storageClient.uploadFile(inputStream, size, type, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (path != null) {
            return path.getFullPath();
        } else {
            return null;
        }
    }

    /**
     * 删除文件
     *
     * @param fullPath
     */
    @Override
    public void deleteFile(String fullPath) {
        storageClient.deleteFile(fullPath);
    }

}
