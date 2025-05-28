package com.strength;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // 💡 启用服务注册发现
@MapperScan(basePackages = {"com.common.dao"})
public class StrengthServiceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(StrengthServiceApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(StrengthServiceApplication.class);
    }
}
