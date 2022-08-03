package com.skillstorm.rentalweb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.skillstorm.rentalweb.tools.EntityIdResolver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "user")
@JsonIdentityInfo(
				generator = ObjectIdGenerators.PropertyGenerator.class, 
				property = "id", 
				resolver = EntityIdResolver.class,
				scope = User.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid")
	private int id;
	
	@NotBlank
	private String name;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phone;
	
	@DateTimeFormat(pattern="yyyyMMdd") //Could add validator for age, could change format
	private Calendar dob;
	
	@Email
	@Column(unique=true)
	private String email;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phone=" + phone + ", birthday=" + dob + ", email=" + email
				+ "]";
	}

	public User() {
		
	}
	
	public User(int id, @NotBlank String name, String phone, Calendar dob, @Email String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.dob = dob;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Calendar getDob() {
		return dob;
	}

	public void setDob(String dob) {
		//TODO: Refactor this to check age/check if valid year
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = sdf.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		this.dob = cal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	
}
