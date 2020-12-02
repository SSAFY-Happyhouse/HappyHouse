package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.mybatis.mapper"})
public class HappyHouseProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyHouseProjectApplication.class, args);
	}

}
