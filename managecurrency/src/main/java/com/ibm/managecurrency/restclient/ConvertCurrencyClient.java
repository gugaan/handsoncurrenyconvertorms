package com.ibm.managecurrency.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="convertcurrency")
public interface ConvertCurrencyClient {

	@GetMapping("/convertcurrency/countrycode/{countrycode}/amount/{amount}")
	public Double convertCurrency(@PathVariable("countrycode")String countrycode, @PathVariable("amount")Double amount);
}
