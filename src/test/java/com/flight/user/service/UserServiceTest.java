package com.flight.user.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.flight.user.bean.BookingInfo;
import com.flight.user.bean.PassengerInfo;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	void bookFlight() throws ParseException {
		PassengerInfo passengerInfo = new PassengerInfo("Parichay", "Sawlani", "Male", 26, "21A", "veg");
		BookingInfo info = new BookingInfo("2022-06-27", "08:30", "Indigo", "Delhi", "Mumbai", "Parichay", "abc@gmail.com", 3000, 1, 0, "Economy class", passengerInfo);
		Integer pnr = userService.bookFlight(info);
		assertThat(pnr).isNotNull();
	}
}
