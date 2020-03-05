package com.fanhehe.home;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableEurekaClient
@SpringBootApplication
public class HomeApplication {
	public static void main(String[] args) {
		SpringApplication.run(HomeApplication.class, args);
	}
}
