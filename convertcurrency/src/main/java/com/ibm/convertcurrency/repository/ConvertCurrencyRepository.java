package com.ibm.convertcurrency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.convertcurrency.entity.ConvertedCurrency;

@Repository
public interface ConvertCurrencyRepository extends JpaRepository<ConvertedCurrency, Long> {
	
	ConvertedCurrency findByCountrycode(String countrycode);

	
}
