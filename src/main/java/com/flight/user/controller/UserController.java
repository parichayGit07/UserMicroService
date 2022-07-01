package com.flight.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flight.user.entity.BookingDetails;
import com.flight.user.entity.PassengerDetails;
import com.flight.user.bean.BookingInfo;
import com.flight.user.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@CrossOrigin
	@PostMapping("/bookFlight")
	public ResponseEntity<Integer> bookFlight(@RequestBody BookingInfo bookingInfo) {
		Integer pnr = null;
		try {
			pnr = userService.bookFlight(bookingInfo);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(pnr,HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/getBookingHistory/{email}")
	public ResponseEntity<Optional<List<BookingDetails>>>  getBookingHistory(@PathVariable String email) {
		Optional<List<BookingDetails>> bookingDetails = null;
		try {
			bookingDetails = userService.getBookingHistory(email);
			if(bookingDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Optional<List<BookingDetails>>>(bookingDetails,HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@GetMapping("/getBookingInfo/{pnr}")
	public ResponseEntity<Optional<BookingDetails>>  getBookingInfo(@PathVariable String pnr) {
		Optional<BookingDetails> bookingDetails = null;
		try {
			bookingDetails = userService.getBookingInfo(pnr);
			if(bookingDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Optional<BookingDetails>>(bookingDetails,HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/getPassengerDetails/{pnr}")
	public ResponseEntity<Optional<List<PassengerDetails>>>  getPassengerDetails(@PathVariable String pnr) {
		Optional<List<PassengerDetails>> passengerDetails = null;
		try {
			passengerDetails = userService.getPassengerDetails(pnr);
			if(passengerDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Optional<List<PassengerDetails>>>(passengerDetails,HttpStatus.OK);
	}
	
	@PutMapping("/cancelTicket/{pnr}")
	public ResponseEntity<Integer> cancelTicket(@PathVariable String pnr){
		try {
			userService.cancelTicket(pnr);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(1,HttpStatus.OK);
	}
	
}
