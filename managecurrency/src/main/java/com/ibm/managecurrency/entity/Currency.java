package com.ibm.managecurrency.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currency")
public class Currency {

	public Currency() {
	}
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="countryCode")
    public String countrycode;
	@Column(name="convertionfactor")
    public Double convertionfactor;
	
	
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
	
    
}