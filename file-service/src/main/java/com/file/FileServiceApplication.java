package com.file;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = {"com.file", "com.api", "com.common"})
@EnableFeignClients(basePackages = "com.api.client")
@EnableDiscoveryClient
@MapperScan(basePackages = {"com.common.dao"})
public class FileServiceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(FileServiceApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(FileServiceApplication.class);
    }
}
