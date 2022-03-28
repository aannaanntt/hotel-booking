package com.hotel.booking.entity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.booking.controller.CustomerController;
import com.hotel.booking.entity.Bill;
import com.hotel.booking.entity.Customer;
import com.hotel.booking.entity.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerrepository;

	public Customer save(Customer cust) {

	
		return customerrepository.save(cust);
	}

}
