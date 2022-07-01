package com.flight.user.bean;

public class PassengerInfo {
private String firstName;
private String lastName;
private String gender;
private Integer age;
private String seatNumber;
private String meal;
public PassengerInfo() {
	super();
	// TODO Auto-generated constructor stub
}
public PassengerInfo(String firstName, String lastName, String gender, Integer age, String seatNumber, String meal) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.age = age;
	this.seatNumber = seatNumber;
	this.meal = meal;
}
public String getFirstName() {
	return firstName;
}
public String getLastName() {
	return lastName;
}
public String getGender() {
	return gender;
}
public Integer getAge() {
	return age;
}
public String getSeatNumber() {
	return seatNumber;
}
public String getMeal() {
	return meal;
}
}
