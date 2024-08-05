package com.palkin.address_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palkin.address_service.entity.Address;
import com.palkin.address_service.repository.AddressRepository;
import com.palkin.address_service.request.CreateAddressRequest;
import com.palkin.address_service.response.AddressResponse;

@Service
public class AddressService {
	
	Logger logger = LoggerFactory.getLogger(AddressService.class);
	
	@Autowired
	AddressRepository addressRepository;

	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
		Address address = new Address();
		
		address.setStreet(createAddressRequest.getStreet());
		address.setCity(createAddressRequest.getCity());
		
		addressRepository.save(address);
		
		return new AddressResponse(address);
	}

	public AddressResponse getById(long id) {
		
		logger.info("Inside getById"+id);
		Address address= addressRepository.findById(id).get();
		return new AddressResponse(address);
	}

}
