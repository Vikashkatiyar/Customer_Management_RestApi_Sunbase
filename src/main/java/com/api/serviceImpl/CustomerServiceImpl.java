package com.api.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.api.entity.Customer;
import com.api.exception.ResourceNotFoundException;
import com.api.repository.CustomerRepository;
import com.api.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	/**
	 * @author vikash katiyar
	 */

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getCustomerList() {
		return customerRepository.findAll();
	}

	@Override
	public Page<Customer> findCustomerWithPaginationAndSorting(int offset, int pageSize, String field) {
		Page<Customer> customers = customerRepository
				.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
		return customers;
	}

	@Override
	public void deleteCustomer(Long cid) {
		Customer existingCustomer = this.customerRepository.findById(cid)
				.orElseThrow(() -> new ResourceNotFoundException("User", " cid ", cid));

		customerRepository.delete(existingCustomer);

	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		Customer existingCustomer = this.customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User", " id ", id));

		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setStreet(customer.getStreet());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setCity(customer.getCity());
		existingCustomer.setState(customer.getState());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setPhone(customer.getPhone());

		return customerRepository.save(existingCustomer);

	}

	@Override
	public Customer getCustomerById(Long customerId) {
		return customerRepository.findByid(customerId);

	}

}
