package com.ac.comehome.dao.impl;

import com.ac.comehome.dao.BaseMapper;
import com.ac.comehome.entity.ChUser;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @program: comehome
 * @description: 用户
 * @author: ErFeng_V
 * @create: 2021-04-11 19:47
 */
@Mapper
public interface ChUserMapper extends BaseMapper<ChUser> {

    @Update("update ch_user set u_isvol =#{uIsvol},u_idcard=#{uIdcard}  where u_openid=#{uOpenid} ")
    public  int updateIsvol(ChUser chUser);
}
