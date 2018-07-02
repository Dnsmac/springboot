package com;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com")//扫描注解包
//多数据源排去除掉自动配置
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}
}
