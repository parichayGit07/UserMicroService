package com.flight.user.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flight.user.bean.BookingInfo;
import com.flight.user.bean.PassengerInfo;
import com.flight.user.entity.BookingDetails;
import com.flight.user.entity.PassengerDetails;

@Service
public class UserService {

	@Autowired
	IBookingDetailsRepository booking_repo;
	
	@Autowired
	IPassengerDetailsRepository passenger_repo;
	
	@Value("${pnr.prefix}")
	private String pnrPrefix;
	
	public Integer bookFlight(BookingInfo bookingInfo) throws ParseException {
		Instant.now().getEpochSecond();
		BookingDetails bookingDetails = new BookingDetails(bookingInfo.getName(), bookingInfo.getEmail(), bookingInfo.getDate(), bookingInfo.getTime(), bookingInfo.getSource(), bookingInfo.getDestination(), bookingInfo.getAirline(), Instant.now().getEpochSecond(), bookingInfo.getPrice(), bookingInfo.getType(),"booked");
		booking_repo.save(bookingDetails);
		bookingDetails.setPnr(pnrPrefix+bookingDetails.getId());
		bookingDetails.setDepartureTime(getUnixDateTime(bookingInfo.getDate(), bookingInfo.getTime()));
		booking_repo.save(bookingDetails);
		PassengerInfo info = bookingInfo.getPassengerInfo();
			PassengerDetails passengerDetails = new PassengerDetails(bookingDetails.getPnr(), info.getFirstName(), info.getLastName(), info.getAge(), info.getGender(), info.getMeal(), info.getSeatNumber());
			passenger_repo.save(passengerDetails);
		return bookingDetails.getId();
	}
	
	public Optional<List<BookingDetails>> getBookingHistory(String email){
		Optional<List<BookingDetails>> bookingDetails = booking_repo.findByEmail(email);
		return bookingDetails;
	}
	
	public Optional<BookingDetails> getBookingInfo(String pnr){
		Optional<BookingDetails> bookingDetails = booking_repo.findByPnr(pnr);
		return bookingDetails;
	}
	
	public Optional<List<PassengerDetails>> getPassengerDetails(String pnr){
		Optional<List<PassengerDetails>> details = passenger_repo.findByPnr(pnr);
		return details;
	}
	
	public void cancelTicket(String pnr) {
		booking_repo.cancelTicket(pnr);
	}
	
	private long getUnixDateTime(String date,String time) throws ParseException {
		String date_time = date+" "+time+":00.0";
		Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(date_time);
		return date1.getTime();
	}
}
