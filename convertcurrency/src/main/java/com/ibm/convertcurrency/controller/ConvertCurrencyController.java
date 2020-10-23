package com.ibm.convertcurrency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.convertcurrency.controller.dto.ConvertedCurrencyDTO;
import com.ibm.convertcurrency.entity.ConvertedCurrency;
import com.ibm.convertcurrency.service.ConvertCurrencyService;

@RequestMapping("convertcurrency")
@RestController
public class ConvertCurrencyController {
	@Autowired
	ConvertCurrencyService convertCurrencyService;
	@GetMapping("/countrycodefromDB/{countrycode}/amount/{amount}")
	public Double convertCurrencyFromDB(@PathVariable("countrycode")String countrycode, @PathVariable("amount")Double amount) {
		return convertCurrencyService.convertCurrency(countrycode, amount);		
		
	}
	@PostMapping("/addconvertcurrency")
	public ResponseEntity<ConvertedCurrency> addConvertedCurrency(@RequestBody ConvertedCurrencyDTO currencyDTO) {
		return ResponseEntity.ok().body(convertCurrencyService.addConvertedCurrency(currencyDTO));
		
	}
	@GetMapping("/countrycode/{countrycode}/amount/{amount}")
	public Double convertCurrency(@PathVariable("countrycode")String countrycode, @PathVariable("amount")Double amount) {
		Double totalamount=0.0;
		if(countrycode.equals("INR")) {
			totalamount=amount*75.5;
		}else if(countrycode.equals("US")) {
			totalamount=amount*50.0;
		}else {
			totalamount=amount*25.25;
		}
		return totalamount;
		
	}
	
}
