package com.demo.singletondemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingletonDemoApplicationTests {

    @Test
    public void contextLoads() {
        SingletonEnum.SINGLETON.m();
        SingletonClass.getInstance().m();
    }

}
