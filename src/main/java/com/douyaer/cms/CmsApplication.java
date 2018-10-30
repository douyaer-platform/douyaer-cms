package com.douyaer.cms;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableAutoConfiguration(exclude={DruidDataSourceAutoConfigure.class})
public class CmsApplication {

	public static void main(String[] args) {
		// SpringApplication.run(CmsApplication.class, args);
		SpringApplication app = new SpringApplication(CmsApplication.class);
		// 禁用devTools热部署
		//System.setProperty("spring.devtools.restart.enabled", "false");
		// 禁用命令行更改application.properties属性
		app.setAddCommandLineProperties(false);
		app.run(args);
	}
}
