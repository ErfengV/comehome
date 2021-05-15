package com.ac.comehome.service.impl;



import com.ac.comehome.entity.ChUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ChUserServiceImplTest {
    @Autowired
    private ChUserServiceImpl chUserService;

    @Test
    public void login() {

    }

    @Test
    public void register() {
        ChUser chUser=new ChUser();
        chUser.setUNickname("张小四");
        chUser.setUOpenid("1102614270");
        chUser.setUCity("小北");
        chUserService.register(chUser);
    }
}
