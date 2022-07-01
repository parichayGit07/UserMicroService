package com.flight.user.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookingDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String name;
private String email;
private String date;
private String time;
private String source;
private String destination;
private String airline;
private String type;
private long dateTime;
private Integer price;
private String pnr;
private String status;
private long departureTime;
public BookingDetails() {
	super();
	// TODO Auto-generated constructor stub
}
public BookingDetails(String name, String email, String date, String time, String source, String destination,
		String airline, long dateTime, Integer price,String type,String status) {
	super();
	this.name = name;
	this.email = email;
	this.date = date;
	this.time = time;
	this.source = source;
	this.destination = destination;
	this.airline = airline;
	this.dateTime = dateTime;
	this.price = price;
	this.type = type;
	this.status = status;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public String getAirline() {
	return airline;
}
public void setAirline(String airline) {
	this.airline = airline;
}
public long getDateTime() {
	return dateTime;
}
public void setDateTime(long dateTime) {
	this.dateTime = dateTime;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public String getPnr() {
	return pnr;
}
public void setPnr(String pnr) {
	this.pnr = pnr;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public long getDepartureTime() {
	return departureTime;
}
public void setDepartureTime(long departureTime) {
	this.departureTime = departureTime;
}
}
