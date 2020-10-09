package com.ibm.managecurrency.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ibm.managecurrency.dto.CurrencyDTO;
import com.ibm.managecurrency.dto.ResponseStatus;
import com.ibm.managecurrency.entity.Currency;
import com.ibm.managecurrency.mapper.CurrencyMapper;
import com.ibm.managecurrency.repository.ManageCurrencyRepository;

@Service
public class ManageCurrencyService {

	@Autowired
	ManageCurrencyRepository manageCurrencyRepository;

	//@HystrixCommand(fallbackMethod = "currencyServiceFallback")
	public Double getCovertionFactor(String countrycode) {

		Currency currency = manageCurrencyRepository.findByCountrycode(countrycode);
		Double convertionFactor = currency.getConvertionfactor();
		return convertionFactor;

	}

	public Double currencyServiceFallback(String countrycode) {

		Currency currency = manageCurrencyRepository.findByCountrycode(countrycode);
		Double convertionFactor = null;
		if (currency != null) {
			convertionFactor = 25.0;

		}
		return convertionFactor;
	}
	
	public ResponseStatus createConversionFactor(CurrencyDTO dto) {
		ResponseStatus responseStatus=new ResponseStatus();
		CurrencyMapper currencymapper= new CurrencyMapper();
		Currency currency=currencymapper.convertToEntity(dto);
		manageCurrencyRepository.save(currency);
		responseStatus.setStatus(ResponseEntity.ok().toString());
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
		responseStatus.setStatus(ResponseEntity.ok().toString());
		responseStatus.setErrorMessage("Updated Successfully");
		}else {
			responseStatus.setStatus(ResponseEntity.noContent().toString());
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