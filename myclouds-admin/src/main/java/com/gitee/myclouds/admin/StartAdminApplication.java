package com.gitee.myclouds.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gitee.myclouds.admin.modules.cache.CacheService;

@SpringBootApplication
//只要添加这个注解即可向配置好的consul注册服务
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan(basePackages = {"com.gitee.myclouds"}, sqlSessionFactoryRef = "sqlSessionFactory")
@ComponentScan(basePackages={"com.gitee.myclouds"})
public class StartAdminApplication {
	
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext  context = SpringApplication.run(StartAdminApplication.class, args);
		CacheService cacheService = context.getBean(CacheService.class);
		cacheService.initCacheWhenSysBoot();
	}

}
