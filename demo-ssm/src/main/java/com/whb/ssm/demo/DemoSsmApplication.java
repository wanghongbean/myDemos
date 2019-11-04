package com.whb.ssm.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSsmApplication {
    //    @Bean
//    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(dataSource());
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.helijia.product.dao.entity");
//        sqlSessionFactoryBean.setMapperLocations(
//                resolver.getResources("classpath*:/sql/**/*.xml,classpath*:/*/**/*Mapper.xml"));
//
//        return sqlSessionFactoryBean;
////        return sqlSessionFactoryBean.getObject();
//    }

//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
//        configurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
//        configurer.setNameGenerator(new AnnotationBeanExtNameGenerator());
//        configurer.setBasePackage("com.helijia.*.*.dao.mapper," +
//                "com.helijia.*.dao.mapper,com.helijia.*.*.*.dao.mapper," +
//                "com.helijia.card.*.service.dao,com.helijia.shop.*.service.dao," +
//                "com.helijia.pivot.inventory.*,com.helijia.shop.inventory.policy.*," +
//                "com.helijia.sso.dao.mapper.PermissionDao" );
////                + ",com.helijia.product.dao.mapper.ArtisanProductMapper");
////        configurer.setBasePackage("classpath*:com/helijia/*/**/dao/*/**/*.class");
////        configurer.setBasePackage("com.helijia.**.dao");
//        return configurer;
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSsmApplication.class, args);
    }
}
