package br.com.microservices.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.microservices.bean.CurrencyConversionBean;

//A indicação da URL sai deste ponto e vai para uma variável no application.properties
//@FeignClient(name="currency-exchange-service", url="localhost:8000")

@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(
			@PathVariable String from, @PathVariable String to); 
}
