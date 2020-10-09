package com.ibm.managecurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
//@EnableHystrix
//@EnableHystrixDashboard
@EnableDiscoveryClient
@SpringBootApplication
public class ManagecurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagecurrencyApplication.class, args);
	}

}
