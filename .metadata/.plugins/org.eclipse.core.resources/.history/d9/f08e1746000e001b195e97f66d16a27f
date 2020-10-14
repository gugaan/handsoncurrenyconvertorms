package com.ibm.managecurrency.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.managecurrency.dto.CurrencyDTO;
import com.ibm.managecurrency.dto.ResponseStatus;
import com.ibm.managecurrency.entity.Currency;
import com.ibm.managecurrency.mapper.CurrencyMapper;
import com.ibm.managecurrency.repository.ManageCurrencyRepository;
import com.ibm.managecurrency.restclient.ConvertCurrencyClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ManageCurrencyService {

	@Autowired
	ManageCurrencyRepository manageCurrencyRepository;
	
	final ConvertCurrencyClient convertCurrencyClient;
	
	public ManageCurrencyService(ConvertCurrencyClient convertCurrencyClient) {
		this.convertCurrencyClient=convertCurrencyClient;
	}

	
	public Double getCovertionFactor(String countrycode) {

		Currency currency = manageCurrencyRepository.findByCountrycode(countrycode);
		Double convertionFactor = currency.getConvertionfactor();
		return convertionFactor;

	}
	@HystrixCommand(fallbackMethod = "convertCurrencyServiceFallback")
	public CurrencyDTO getCurrency(String countrycode) {

		Currency currency = manageCurrencyRepository.findByCountrycode(countrycode);
		CurrencyMapper currencymapper= new CurrencyMapper();
		CurrencyDTO dto=currencymapper.convertToDto(currency);
		Double convertedamount= convertCurrencyClient.convertCurrency(countrycode, dto.getConvertionfactor());
		dto.setConvertedamount(convertedamount);
		return dto;

	}
	public CurrencyDTO convertCurrencyServiceFallback(String countrycode) {

		Currency currency = manageCurrencyRepository.findByCountrycode(countrycode);
		CurrencyMapper currencymapper= new CurrencyMapper();
		CurrencyDTO dto=currencymapper.convertToDto(currency);
		if (currency != null) {
			dto.setConvertedamount(55.65);
		}
		return dto;
	}
	
	public ResponseStatus createConversionFactor(CurrencyDTO dto) {
		ResponseStatus responseStatus=new ResponseStatus();
		CurrencyMapper currencymapper= new CurrencyMapper();
		Currency currency=currencymapper.convertToEntity(dto);
		manageCurrencyRepository.save(currency);
		responseStatus.setStatus(HttpStatus.OK.name());
		responseStatus.setErrorMessage("Updated Successfully");
		return responseStatus;
	}
	public ResponseStatus updateConversionFactor(CurrencyDTO dto) {	
		ResponseStatus responseStatus=new ResponseStatus();
		Currency currency = manageCurrencyRepository.findByCountrycode(dto.countrycode);
		if(currency != null) {
		currency.setCountrycode(dto.getCountrycode());
		currency.setConvertionfactor(dto.getConvertionfactor());
		manageCurrencyRepository.save(currency);
		responseStatus.setStatus(HttpStatus.OK.name());
		responseStatus.setErrorMessage("Updated Successfully");
		}else {
			responseStatus.setStatus(HttpStatus.NO_CONTENT.name());
			responseStatus.setErrorMessage("There is no country code exists");
		}
		return responseStatus;
	}

	public CurrencyDTO getCovertionFactorByID(Long id) {
		Optional<Currency> currency = manageCurrencyRepository.findById(id);
		CurrencyMapper currencymapper= new CurrencyMapper();
		CurrencyDTO currencyDto=currencymapper.convertToDto(currency.get());
		return currencyDto;
	}
}
