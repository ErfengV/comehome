package com.ac.comehome.dao.impl;

import com.ac.comehome.dao.BaseMapper;
import com.ac.comehome.entity.ChEquipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @program: comehome
 * @description: 设备绑定接口
 * @author: ErFeng_V
 * @create: 2021-04-11 19:54
 */
@Mapper
public interface ChEquipmentMapper extends BaseMapper<ChEquipment> {

    @Update("update ch_equipment set e_state=#{eState}  where e_id=#{eId}")
    public  int updateState(ChEquipment chEquipment);

    @Update("update ch_equipment set e_desc=#{eDesc}  where e_id=#{eId}")
    public  int updateDesc(ChEquipment chEquipment);
}
