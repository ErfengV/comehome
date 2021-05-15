package com.ac.comehome.service.impl;

import com.ac.comehome.dao.impl.ChEquipmentMapper;
import com.ac.comehome.dao.impl.ChTaskMapper;
import com.ac.comehome.entity.ChTask;
import com.ac.comehome.service.ChTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: comehome
 * @description:
 * @author: ErFeng_V
 * @create: 2021-04-11 20:12
 */
@Service
public class ChTaskServiceImpl implements ChTaskService {

    private ChTaskMapper taskMapper;

    @Autowired(required = false)
    public void setTaskMapper (ChTaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }
    /**
     * 发布任务操作
     * @param task
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean publishTask(ChTask task) {
        return taskMapper.insert(task)==1;
    }

    /**
     * 关闭任务操作，修改任务状态
     * @param task
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean closeTask(ChTask task) {
        return taskMapper.updateByPrimaryKey(task)==1;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ChTask> findAllTask() {
        return taskMapper.selectAll();
    }
}
