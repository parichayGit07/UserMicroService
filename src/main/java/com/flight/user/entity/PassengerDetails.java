package com.flight.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PassengerDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String pnr;
private String firstName;
private String lastName;
private Integer age;
private String gender;
private String meal;
private String seatNumber;
public PassengerDetails() {
	super();
	// TODO Auto-generated constructor stub
}
public PassengerDetails(String pnr, String firstName, String lastName, Integer age, String gender, String meal,
		String seatNumber) {
	super();
	this.pnr = pnr;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.gender = gender;
	this.meal = meal;
	this.seatNumber = seatNumber;
}
public String getPnr() {
	return pnr;
}
public void setPnr(String pnr) {
	this.pnr = pnr;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getMeal() {
	return meal;
}
public void setMeal(String meal) {
	this.meal = meal;
}
public String getSeatNumber() {
	return seatNumber;
}
public void setSeatNumber(String seatNumber) {
	this.seatNumber = seatNumber;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
}
