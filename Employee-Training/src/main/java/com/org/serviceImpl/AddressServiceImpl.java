package com.org.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.exception.ResourceNotFoundException;
import com.org.model.Address;
import com.org.repository.AddressRepository;
import com.org.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public List<Address> getAddress() {
		return addressRepository.findAll();
	}

	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address editAddress(Address address, int addressId) throws ResourceNotFoundException {
	
		Address address1 = 
			addressRepository.findById(addressId).orElseThrow( () -> 
	new ResourceNotFoundException("Address Id is not found " + addressId));
			
		address1 = addressRepository.saveAndFlush(address);
		return address1;
	//	return addressRepository.saveAndFlush(address);
	
		}

	@Override
	public void deleteAddress(int addressId) throws ResourceNotFoundException {
		
		Address address = 
				addressRepository.findById(addressId).orElseThrow( () -> 
		new ResourceNotFoundException("Address Id is not found " + addressId));
		
		// System.out.println(address);
		
		 addressRepository.deleteById(addressId);
		
	}

	
}