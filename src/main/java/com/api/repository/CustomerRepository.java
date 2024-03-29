package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	/**
	 * 
	 * @author vikash katiyar
	 * 
	 */

	Customer findByid(Long id);

}
