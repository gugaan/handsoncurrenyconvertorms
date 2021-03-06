package com.ibm.managecurrency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@SpringBootApplication
public class ManagecurrencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagecurrencyApplication.class, args);
	}

}
