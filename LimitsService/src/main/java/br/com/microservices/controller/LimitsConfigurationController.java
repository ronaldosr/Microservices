package br.com.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.microservices.bean.LimitConfiguration;
import br.com.microservices.config.Configuration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration config;
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return new LimitConfiguration(
				config.getMaximum(), config.getMinimum());
	}
	
	@GetMapping("/limits-fault")
	@HystrixCommand(fallbackMethod ="fallbackRetrieveLimitsFaultFromConfigurations" )
	public LimitConfiguration retrieveLimitsFaultFromConfigurations() {
		throw new RuntimeException("Not Available");
	}
	
	public LimitConfiguration fallbackRetrieveLimitsFaultFromConfigurations() {
		return new LimitConfiguration(999, 9);
	}
}
