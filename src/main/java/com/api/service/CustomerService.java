package com.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.entity.Customer;

public interface CustomerService {

	Customer createCustomer(Customer customer);

	List<Customer> getCustomerList();

	void deleteCustomer(Long id);

	Customer updateCustomer(Long id, Customer customer);

	Customer getCustomerById(Long customerId);

	Page<Customer> findCustomerWithPaginationAndSorting(int offset, int pageSize, String field);

}
