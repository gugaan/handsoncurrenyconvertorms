package com.ibm.convertcurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.convertcurrency.service.ConvertCurrencyService;

@RequestMapping("convertcurrency")
@RestController
public class ConvertCurrencyController {
	@Autowired
	ConvertCurrencyService convertCurrencyService;
	@GetMapping("/countrycode/{countrycode}/amount/{amount}")
	public Double convertCurrency(@PathVariable("countrycode")String countrycode, @PathVariable("amount")Double amount) {
		return convertCurrencyService.convertCurrency(countrycode, amount);		
		
	}

}
