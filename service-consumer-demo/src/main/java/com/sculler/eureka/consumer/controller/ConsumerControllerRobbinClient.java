package com.sculler.eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerControllerRobbinClient {
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/robbin/test")
	public String loadTest() {
		return restTemplate.getForObject("http://SERVICE-PRODUCER-DEMO/loadbalancer/test", String.class);
	}

}
