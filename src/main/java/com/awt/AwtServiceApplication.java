package com.awt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// @EnableDiscoveryClient
public class AwtServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwtServiceApplication.class, args);
		System.out.println("hello shubham");
	}

}
