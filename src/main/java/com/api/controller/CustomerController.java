package com.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.entity.Customer;
import com.api.payload.ApiResponse;
import com.api.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	/**
	 * @author vikash katiyar
	 */

	@Autowired
	private CustomerService customerService;

	@PostMapping("/create")
	public ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer) {
		Customer createdCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>("Customer Successfully Created", HttpStatus.CREATED);
	}

	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		if (customer != null) {
			return ResponseEntity.ok(customer);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/getCustomerList")
	public ResponseEntity<List<Customer>> getCustomerList() {
		List<Customer> customerList = customerService.getCustomerList();
		return new ResponseEntity<>(customerList, HttpStatus.OK);
	}

	@GetMapping("/pagination/{offset}/{pageSize}/{field}")
	public ResponseEntity<List<Customer>> findCustomerWithPaginationAndSorting(@PathVariable int offset,
			@PathVariable int pageSize, @PathVariable String field) {
		Page<Customer> customersPage = customerService.findCustomerWithPaginationAndSorting(offset, pageSize, field);
		List<Customer> customersList = new ArrayList<>();
		for (Customer customer : customersPage.getContent()) {
			customersList.add(customer);
		}
		return new ResponseEntity<List<Customer>>(customersList, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updateCustomer(id, customer);
		return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}

}
