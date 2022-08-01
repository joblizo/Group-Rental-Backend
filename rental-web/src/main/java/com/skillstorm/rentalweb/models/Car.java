package com.skillstorm.rentalweb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "car")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "license")
public class Car {
	
//	Add validation annotations
	@Id
	@NotBlank
	private String license; //TODO: Add validator for license
	@NotNull
	private int capacity;
	@NotBlank
	private String make;
	@NotBlank
	private String model;
	@NotNull
	private int year; //Tinyint on DB, check if it should be changed to a DATE type
	@NotNull
	private int isAvailable;
	
	@Override
	public String toString() {
		return "Car [license=" + license + ", capacity=" + capacity + ", make=" + make + ", model=" + model + ", year="
				+ year + ", isAvailable=" + isAvailable + "]";
	}
	
	public Car() {
	}

	public Car(String license, int capacity, String make, String model, int year, int isAvailable) {
		super();
		this.license = license;
		this.capacity = capacity;
		this.make = make;
		this.model = model;
		this.year = year;
		this.isAvailable = isAvailable;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(int isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	
	
	
	
}
