package com.org.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@AttributeOverrides({
	@AttributeOverride(name = "employeeId", column = @javax.persistence.Column(name="employeeId"))
})
public class Address extends Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private String StreetName;
	private String city;
	private String state;
	private String country;
	
}
