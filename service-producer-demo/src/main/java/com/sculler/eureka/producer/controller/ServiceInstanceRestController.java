package com.sculler.eureka.producer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceInstanceRestController {
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/loadbalancer/test")
	public String loadTest() {
		return "{port:" + port + "}";
	}
}
