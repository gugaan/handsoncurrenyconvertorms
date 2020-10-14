package com.ibm.convertcurrency.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.convertcurrency.entity.ConvertedCurrency;
import com.ibm.convertcurrency.repository.ConvertCurrencyRepository;

@Service
public class ConvertCurrencyService {

	@Autowired
	ConvertCurrencyRepository convertCurrencyRepository;

	public Double convertCurrency(String countrycode, Double amount) {
		Double convertedamount = 0.0;
		ConvertedCurrency convertedCurrency = convertCurrencyRepository.findByCountrycode(countrycode);
		if (convertedCurrency != null && convertedCurrency.convertionamount != null
				&& convertedCurrency.convertionamount != 0.0) {
			convertedamount = amount * convertedCurrency.convertionamount;
		}else {
			convertedamount = amount * 12.0;
		}
		return convertedamount;

	}
}
