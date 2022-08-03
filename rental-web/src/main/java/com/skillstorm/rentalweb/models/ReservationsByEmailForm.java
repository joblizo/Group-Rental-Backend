package com.skillstorm.rentalweb.models;

import javax.validation.constraints.Email;

public class ReservationsByEmailForm {
	
	@Email
	private String email;

	@Override
	public String toString() {
		return "ReservationsByEmailForm [email=" + email + "]";
	}
	
	public ReservationsByEmailForm() {
	}

	public ReservationsByEmailForm(@Email String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
