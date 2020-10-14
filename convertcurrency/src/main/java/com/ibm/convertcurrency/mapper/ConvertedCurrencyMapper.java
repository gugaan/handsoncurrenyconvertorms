package com.ibm.convertcurrency.mapper;

import com.ibm.convertcurrency.controller.dto.ConvertedCurrencyDTO;
import com.ibm.convertcurrency.entity.ConvertedCurrency;

public class ConvertedCurrencyMapper {

	public ConvertedCurrency convertToEntity(ConvertedCurrencyDTO dto) {

		ConvertedCurrency entity = new ConvertedCurrency();
		entity.setId(dto.getId());
		entity.setCountrycode(dto.getCountrycode());
		entity.setConvertionamount(dto.getConvertionamount());
		return entity;
	}

	public ConvertedCurrencyDTO convertToDto(ConvertedCurrency currency) {

		ConvertedCurrencyDTO dto = new ConvertedCurrencyDTO();
		dto.setId(currency.getId());
		dto.setCountrycode(currency.getCountrycode());
		dto.setConvertionamount(currency.getConvertionamount());
		return dto;
	}
}
