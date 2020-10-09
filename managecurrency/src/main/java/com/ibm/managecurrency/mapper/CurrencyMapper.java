package com.ibm.managecurrency.mapper;

import com.ibm.managecurrency.dto.CurrencyDTO;
import com.ibm.managecurrency.entity.Currency;

public class CurrencyMapper {

	public Currency convertToEntity(CurrencyDTO dto) {

		Currency entity = new Currency();
		entity.setId(dto.getId());
		entity.setCountrycode(dto.getCountrycode());
		entity.setConvertionfactor(dto.getConvertionfactor());
		return entity;
	}

	public CurrencyDTO convertToDto(Currency currency) {

		CurrencyDTO dto = new CurrencyDTO();
		dto.setId(currency.getId());
		dto.setCountrycode(currency.getCountrycode());
		dto.setConvertionfactor(currency.getConvertionfactor());
		return dto;
	}
}