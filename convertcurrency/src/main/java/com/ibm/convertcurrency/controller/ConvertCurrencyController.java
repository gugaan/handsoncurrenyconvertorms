package com.ibm.convertcurrency.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertCurrencyController {
	
	@GetMapping("/countrycode/{countrycode}/amount/{amount}")
	public Double convertCurrency(@PathVariable("countrycode")String countrycode, @PathVariable("amount")Double amount) {
		return null;
		
	}

}