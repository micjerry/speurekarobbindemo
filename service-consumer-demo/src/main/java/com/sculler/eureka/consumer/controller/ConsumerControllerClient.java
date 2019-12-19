package com.sculler.eureka.consumer.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerControllerClient {
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@RequestMapping("/loadbalancer/test")
	public String loadTest() {
		ServiceInstance serviceInstance = loadBalancer.choose("service-producer-demo");
		
		if (null == serviceInstance) {
			System.out.println("Can not get service");
			return null;
		}
		
		String baseUrl = serviceInstance.getUri().toString();
		
		baseUrl=baseUrl+"/loadbalancer/test";
		
		ResponseEntity<String> response = null;
		try{
			RestTemplate restTemplate = new RestTemplate();
			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
		} catch (Exception ex)
		{
			System.out.println(ex);
		}
		
		if (response != null) {
			return response.getBody();
		}
		
		return null;
	}
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
}
