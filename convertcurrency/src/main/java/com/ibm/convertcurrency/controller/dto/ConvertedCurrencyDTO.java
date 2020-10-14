package com.ibm.convertcurrency.controller.dto;

public class ConvertedCurrencyDTO {
	
	
	public ConvertedCurrencyDTO() {
	}
	private Long id;
    public String countrycode;
    public Double convertionamount;
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
	public Double getConvertionamount() {
		return convertionamount;
	}
	public void setConvertionamount(Double convertionamount) {
		this.convertionamount = convertionamount;
	}
    
    
}
