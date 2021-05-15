package com.ac.comehome.dao.impl;

import com.ac.comehome.dao.BaseMapper;
import com.ac.comehome.entity.ChTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @program: comehome
 * @description: 寻找信息发布
 * @author: ErFeng_V
 * @create: 2021-04-11 19:49
 */
@Mapper
public interface ChTaskMapper extends BaseMapper<ChTask> {


}
