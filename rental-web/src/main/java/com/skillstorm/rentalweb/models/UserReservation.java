package com.skillstorm.rentalweb.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

@Entity
@Table(name = "userreservations")
public class UserReservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rID")
	private int rId;
	
	//TODO: Can a reservation have many cars?
	@OneToOne
	@JoinColumn(name = "license")
	@JsonIdentityReference(alwaysAsId = true)
	private Car car;
	
	@ManyToOne
	@JoinColumn(name = "uid")
	@JsonIdentityReference(alwaysAsId = true)
	private User user;
	
	@DateTimeFormat(pattern="yyyyMMdd")
	private Calendar rStart;
	@DateTimeFormat(pattern="yyyyMMdd")
	private Calendar rEnd;
	
	@Override
	public String toString() {
		return "UserReservation [rId=" + rId + ", car=" + car + ", user=" + user + ", rStart=" + rStart + ", rEnd="
				+ rEnd + "]";
	}

	public UserReservation() {
		
	}

	public UserReservation(int rId, Car car, User user, Calendar rStart, Calendar rEnd) {
		super();
		this.rId = rId;
		this.car = car;
		this.user = user;
		this.rStart = rStart;
		this.rEnd = rEnd;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Calendar getrStart() {
		return rStart;
	}

	public void setrStart(String rStart) {
		this.rStart = parseDate(rStart);
	}

	public Calendar getrEnd() {
		return rEnd;
	}

	public void setrEnd(String rEnd) {
		this.rEnd = parseDate(rEnd);;
	}
	
	private Calendar parseDate(String toParse) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = sdf.parse(toParse);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	
	
	
	
	
	
	
}
