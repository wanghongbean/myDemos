package com.whb.web.demoweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Title MyWebMvcConfigurer.java
 * @Project demo-web
 * @Description 自定义mvc配置
 * @author bean wanghb_prm@si-tech.com.cn
 * @create 2018-07-18 
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Myinterceptor()).addPathPatterns("/**").excludePathPatterns("index");
        super.addInterceptors(registry);
    }
}
