package com.ibm.managecurrency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.managecurrency.entity.Currency;

@Repository
public interface ManageCurrencyRepository extends JpaRepository<Currency, Long> {
	
	Currency findByCountrycode(String countrycode);

	
}
