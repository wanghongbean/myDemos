package com.example.log;

import com.example.log.entity.Tar;
import com.example.log.entity.User;
import com.example.log.rep.UserRep;
import com.example.log.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Date;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoLogApplicationTests {
    @Resource
    UserService userService;
    @Resource
    UserRep rep;

    @Test
    @Transactional
    public void contextLoads() throws Exception {
//		User d = new User(1, "d", new Date());
//		User save = rep.save(d);

        User one = rep.getOne(2);
        Tar tar = copyBean(one, Tar.class);


        System.out.println(tar);

    }

    @Test
    @Transactional
    public void test() throws Exception {
        userService.test(2);
    }

    @Test
    public void test2() {
        Integer a = 128;
        Integer b = 128;
        Integer c = 256;
        Integer d = 256;
        System.out.println(a == b);
        System.out.println(c == d);
        System.out.println("--------------------");

        int z = 128;
        int x = 128;
        int s = 256;
        int f = 256;
        System.out.println(z == x);
        System.out.println(s == f);
        System.out.println("=====================");

        System.out.println(a == z);
        ArrayList<Object> as = new ArrayList<>();
        as.add(1);
        as.add(2);
        as.add(3);
        as.add(4);
        int i = as.indexOf(2);
        as.add(i + 1, 99);
        for (int j = 0; j < as.size(); j++) {
            System.out.println(as.get(j));
        }

    }

    public static <T> T copyBean(Object source, Class<T> target) throws Exception {

        Constructor<T> constructor = null;
        T t = null;
        try {
            constructor = target.getConstructor();
            constructor.setAccessible(true);
            t = constructor.newInstance();
            System.out.println("--$$-- 当前类= CoospBeanUtil.copyBeans()--- t.getClass() : " + t.getClass());
            BeanUtils.copyProperties(source, t);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();

        }
        return t;
    }

}
