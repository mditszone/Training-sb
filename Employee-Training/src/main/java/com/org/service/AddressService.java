package com.org.service;

import java.util.List;

import com.org.exception.ResourceNotFoundException;
import com.org.model.Address;

public interface AddressService {

	public List<Address> getAddress();
	public Address saveAddress(Address address);
	public Address editAddress(Address address, int addressId) throws ResourceNotFoundException;
	public void deleteAddress(int id) throws ResourceNotFoundException;
	
	
}
