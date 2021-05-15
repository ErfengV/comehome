package com.ac.comehome.service;

import com.ac.comehome.entity.ChUser;

/**
 * @program: comehome
 * @description: 用户服务 接口
 * @author: ErFeng_V
 * @create: 2021-04-11 20:13
 */
public interface ChUserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    public ChUser login(ChUser user);

    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean register(ChUser user);

    /**
     * 用户是否已经注册过
     * @param user
     * @return
     */
    public boolean isRegister(ChUser user);

    /**
     * 更新志愿者信息
     * @param user
     * @return
     */
    public boolean updateIsvol(ChUser user);
}
