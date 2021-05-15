package com.ac.comehome.service;

import com.ac.comehome.entity.ChTask;

import java.util.List;

/**
 * @program: comehome
 * @description: 任务接口
 * @author: ErFeng_V
 * @create: 2021-04-14 20:07
 */
public interface ChTaskService {
    /**
     * 发布任务
     * @param task
     * @return
     */
    public boolean publishTask(ChTask task);

    /**
     * 任务完成后，关闭任务
     * @param task
     * @return
     */
    public boolean closeTask(ChTask task);

    /**
     * 显示所有的任务
     * @return
     */
    public List<ChTask> findAllTask();
}
