package com.ibm.managecurrency.dto;

public class CurrencyDTO {

	public CurrencyDTO() {
	}

	public Long id;
	public String countrycode;
	public Double convertionfactor;
	public Double convertedamount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public Double getConvertionfactor() {
		return convertionfactor;
	}

	public void setConvertionfactor(Double convertionfactor) {
		this.convertionfactor = convertionfactor;
	}

	public Double getConvertedamount() {
		return convertedamount;
	}

	public void setConvertedamount(Double convertedamount) {
		this.convertedamount = convertedamount;
	}

}
