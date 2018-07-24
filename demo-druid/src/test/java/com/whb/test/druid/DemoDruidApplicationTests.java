package com.whb.test.druid;

import com.alibaba.fastjson.JSON;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoDruidApplicationTests {

	@Autowired
	DataSource dataSource;

	@Autowired
	StringEncryptor stringEncryptor;

	@Test
	public void encryptPwd() {
		String result = stringEncryptor.encrypt("1234");
		System.out.println(result);
	}

	@Test
	public void contextLoads() throws SQLException {
		Connection connection = dataSource.getConnection();
		System.out.println(dataSource);
	}

}
