package com.ac.comehome.service;

import com.ac.comehome.entity.ChEquipment;

/**
 * @program: comehome
 * @description: 设备绑定接口
 * @author: ErFeng_V
 * @create: 2021-04-15 19:57
 */
public interface ChEquipmentService {

    /**
     * 绑定设备
     * @param chEquipment
     * @return
     */
    public boolean bindEqui(ChEquipment chEquipment);


    /**
     * 检验设备是否合法
     * @param chEquipment
     * @return
     */
    public boolean checkEqui(ChEquipment chEquipment);

    /**
     * 停用设备
     * @param chEquipment
     * @return
     */
    public boolean closeEqui(ChEquipment chEquipment);

    /**
     * 修改设备描述信息
     * @param chEquipment
     * @return
     */
    public boolean updateDescEqui(ChEquipment chEquipment);
}
