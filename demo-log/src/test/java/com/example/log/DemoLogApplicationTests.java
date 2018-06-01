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
import java.util.Date;

@RunWith(SpringRunner.class)
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

	public static  <T> T copyBean(Object source, Class<T> target) throws Exception{

		Constructor<T> constructor = null;
		T t=null;
		try {
			constructor = target.getConstructor();
			constructor.setAccessible(true);
			t= constructor.newInstance();
			System.out.println("--$$-- 当前类= CoospBeanUtil.copyBeans()--- t.getClass() : "+t.getClass());
			BeanUtils.copyProperties(source,t);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();

		}
		return t;
	}

}
