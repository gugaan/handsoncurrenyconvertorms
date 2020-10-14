package com.ibm.convertcurrency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="convertedcurrency")
public class ConvertedCurrency {

	public ConvertedCurrency() {
	}
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="countryCode")
    public String countrycode;
	@Column(name="convertionamount")
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
