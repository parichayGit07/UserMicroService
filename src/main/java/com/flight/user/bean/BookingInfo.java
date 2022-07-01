package com.flight.user.bean;

import java.util.List;

public class BookingInfo {
private String date;
private String time;
private String airline;
private String source;
private String destination;
private String name;
private String email;
private Integer price;
private int eSeats;
private int bSeats;
private String type;
private PassengerInfo passengerInfo;
public BookingInfo() {
	super();
	// TODO Auto-generated constructor stub
}
public BookingInfo(String date, String time, String airline, String source, String destination, String name,
		String email, Integer price, int eSeats, int bSeats, String type, PassengerInfo passengerInfo) {
	super();
	this.date = date;
	this.time = time;
	this.airline = airline;
	this.source = source;
	this.destination = destination;
	this.name = name;
	this.email = email;
	this.price = price;
	this.eSeats = eSeats;
	this.bSeats = bSeats;
	this.type = type;
	this.passengerInfo = passengerInfo;
}
public String getDate() {
	return date;
}
public String getTime() {
	return time;
}
public String getAirline() {
	return airline;
}
public String getSource() {
	return source;
}
public String getDestination() {
	return destination;
}
public String getName() {
	return name;
}
public String getEmail() {
	return email;
}
public Integer getPrice() {
	return price;
}
public int geteSeats() {
	return eSeats;
}
public int getbSeats() {
	return bSeats;
}
public String getType() {
	return type;
}
public PassengerInfo getPassengerInfo() {
	return passengerInfo;
}

}
