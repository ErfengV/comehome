package com.ac.comehome.service.impl;

import com.ac.comehome.dao.impl.ChUserMapper;
import com.ac.comehome.entity.ChUser;
import com.ac.comehome.service.ChUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @program: comehome
 * @description: 用户服务
 * @author: ErFeng_V
 * @create: 2021-04-11 20:11
 */
@Service
public class ChUserServiceImpl implements ChUserService {

    private ChUserMapper userMapper;

    @Autowired(required = false)
    public void setChUserMapper (ChUserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    @Transactional(rollbackFor = Exception.class,readOnly = true)
    public ChUser login(ChUser user) {
        //结果只能返回一条数据，否则会抛出异常
        ChUser chUser = null;
        try {
            chUser=userMapper.selectOne(user);
        }catch (Exception e){
            return null;
        }
        return chUser;
    }

    @Override
    public boolean register(ChUser user) {
        return userMapper.insert(user)==1;
    }

    @Override
    public boolean isRegister(ChUser user) {
        ChUser user1=new ChUser(user.getUOpenid());
        return userMapper.selectOne(user1)!=null;
    }

    @Override
    public boolean updateIsvol(ChUser user) {
        return userMapper.updateIsvol(user)==1;
    }



}
