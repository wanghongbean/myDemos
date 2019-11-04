package com.whb.test.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.helijia.framework.datasource.cfg.SimplePasswordCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoDruidApplication {


    @Bean("myTest")
    public MyTest myTest() {
        return new MyTest();
    }


//	@Bean("simplePasswordCallback")
//	@ConfigurationProperties(prefix = "db")
//	public SimplePasswordCallback simplePasswordCallback(){
//		SimplePasswordCallback simplePasswordCallback = new SimplePasswordCallback();
//		simplePasswordCallback.setPassword("5dd43843b44dba0fc4800950e9375a0e");
//		return simplePasswordCallback;
//	}

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSource() {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
//		String e = dataSource.getPassword();
//		simplePasswordCallback().d
//		try {
//			dataSource.setPasswordCallbackClassName("SimplePasswordCallback");
//			dataSource.setPasswordCallback();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
        return dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoDruidApplication.class, args);
    }
}
