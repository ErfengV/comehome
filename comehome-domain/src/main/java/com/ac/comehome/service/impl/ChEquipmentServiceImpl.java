package com.ac.comehome.service.impl;

import com.ac.comehome.dao.impl.ChEquipmentMapper;
import com.ac.comehome.entity.ChEquipment;
import com.ac.comehome.service.ChEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: comehome
 * @description:
 * @author: ErFeng_V
 * @create: 2021-04-15 19:58
 */
@Service
public class ChEquipmentServiceImpl implements ChEquipmentService {


    private ChEquipmentMapper chEquipmentMapper;

    @Autowired(required = false)
    public void setChEquipmentMapper (ChEquipmentMapper chEquipmentMapper) {
        this.chEquipmentMapper = chEquipmentMapper;
    }
    /**
     * 绑定设备信息
     * @param chEquipment
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean bindEqui(ChEquipment chEquipment) {
        return chEquipmentMapper.insert(chEquipment)==1;
    }

    /**
     * 检验信息输入是否合法
     * @param chEquipment
     * @return
     */
    @Override
    public boolean checkEqui(ChEquipment chEquipment) {
        return chEquipmentMapper.selectOne(chEquipment)!=null;
    }

    /**
     * 停用该设备
     * @param chEquipment
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean closeEqui(ChEquipment chEquipment) {
        return chEquipmentMapper.updateState(chEquipment)==1;
    }

    /**
     * 停用该设备
     * @param chEquipment
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateDescEqui(ChEquipment chEquipment) {
        return chEquipmentMapper.updateDesc(chEquipment)==1;
    }


}
