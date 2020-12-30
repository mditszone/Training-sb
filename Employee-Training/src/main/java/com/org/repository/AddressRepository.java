package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	
	
}
