package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.exception.ResourceNotFoundException;
import com.org.model.Address;
import com.org.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	private AddressService addressService;

	// public String final GETAddress = "/getAddress";

	@GetMapping("/getAddress")
	public List<Address> getAllAddress() {
		return addressService.getAddress();
	}

	@PostMapping("/saveAddress")
	public Address createAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}

	@PutMapping("/edit/{id}")
	public Address updateAddress(@RequestBody Address address, @PathVariable int id) throws ResourceNotFoundException {

		return addressService.editAddress(address, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteAddress(@PathVariable int id) throws ResourceNotFoundException {

		addressService.deleteAddress(id); // delete the address

		return "Address Id is Deleted " + id;

	}
}
