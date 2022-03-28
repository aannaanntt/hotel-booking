package com.hotel.booking.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.booking.advice.InputNotFoundException;
import com.hotel.booking.dto.CustomerDTO;
import com.hotel.booking.entity.Customer;
import com.hotel.booking.entity.service.CustomerService;


@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	ModelMapper modelmapper;

	@PostMapping("/addcustomer")
	private ResponseEntity<CustomerDTO> addcustomer(@RequestBody CustomerDTO custDto) {
		if (custDto.getReservation().size() == 0 || custDto.getRoom().size() == 0) {
			throw new InputNotFoundException("Inputs are empty");
		}

		Customer c = modelmapper.map(custDto, Customer.class);

		Customer customer = customerService.save(c);

		CustomerDTO response = modelmapper.map(customer, CustomerDTO.class);

		return new ResponseEntity<CustomerDTO>(response, HttpStatus.CREATED);
	}

}
