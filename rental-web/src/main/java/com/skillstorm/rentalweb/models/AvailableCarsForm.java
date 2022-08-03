package com.skillstorm.rentalweb.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AvailableCarsForm {
	
	private int capacity;
	private int startDate;
	private int endDate;
	
	
	
	@Override
	public String toString() {
		return "AvailableCarsForm [capacity=" + capacity + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

	AvailableCarsForm(){
		
	}
	
	public AvailableCarsForm(int capacity, Date startDate, Date endDate) {
		//Converts Date to Int
		super();
		this.capacity = capacity;
		this.startDate = dateToInt(startDate);
		this.endDate = dateToInt(endDate);
	}

	public AvailableCarsForm(int capacity, int startDate, int endDate) {
		super();
		this.capacity = capacity;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}
	
	public int dateToInt(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(date);
		return Integer.parseInt(dateString);
	}
	

}
