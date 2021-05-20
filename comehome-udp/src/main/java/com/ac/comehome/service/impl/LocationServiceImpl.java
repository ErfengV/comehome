package com.ac.comehome.service.impl;

import com.ac.comehome.bean.Coordinate;
import com.ac.comehome.service.LocationService;
import com.ac.comehome.util.AesEncryptUtils;
import com.ac.comehome.util.MongodbUtils;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * program:comehome
 * description:businessserviceimpl
 * author:lsj
 * create:2021-05-08 21:20
 */
@Service
public class LocationServiceImpl implements LocationService {
    private static final Logger logger = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Override
    @Async("threadPoolTaskExecutor")
    public void udpHandleMethod(String message) throws Exception {
        try {
            String json = AesEncryptUtils.decrypt(message);
            JSONObject obj = JSONObject.parseObject(json);
            Coordinate coordinate = new Coordinate();
            coordinate.setAndroidID(obj.getString("androidId"));
            coordinate.setAppX(new BigDecimal(obj.getString("longitude")));
            coordinate.setAppY(new BigDecimal(obj.getString("latitude")));
            coordinate.setAppDate(new Date());
            MongodbUtils.save(coordinate, coordinate.getAndroidID());
            System.out.println(MongodbUtils.findAll(coordinate, coordinate.getAndroidID()));
            System.out.println("插入数据库成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
