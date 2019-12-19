package com.sculler.eureka.producer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;

@Configuration
public class EurekaProducerConfig {
	@Bean
	public HealthCheckHandler healthCheckHandler() {
		return new HealthCheckHandler() {
			@Override
			public InstanceInfo.InstanceStatus getStatus(
					InstanceInfo.InstanceStatus currentStatus) {
				return InstanceInfo.InstanceStatus.UP;
			}
		};
	}

}
