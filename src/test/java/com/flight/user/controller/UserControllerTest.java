package com.flight.user.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.flight.user.bean.BookingInfo;
import com.flight.user.bean.PassengerInfo;
import com.flight.user.entity.BookingDetails;
import com.flight.user.entity.PassengerDetails;
import com.flight.user.service.IBookingDetailsRepository;
import com.flight.user.service.UserService;

@SpringBootTest
public class UserControllerTest {
	@Autowired
	UserController controller;
	
	@Autowired
	IBookingDetailsRepository booking_repo;
	
	@Test
	void bookFlight() {
		PassengerInfo passengerInfo = new PassengerInfo("Parichay", "Sawlani", "Male", 26, "21A", "veg");
		BookingInfo info = new BookingInfo("2022-06-27", "08:30", "Indigo", "Delhi", "Mumbai", "Parichay", "abc@gmail.com", 3000, 1, 0, "Economy class", passengerInfo);
		ResponseEntity<Integer> response = controller.bookFlight(info);
		Integer booking_id = response.getBody();
		Integer resp_code = response.getStatusCodeValue();
		assertThat(resp_code).isEqualTo(200);
		Optional<BookingDetails> booking_details = booking_repo.findById(booking_id);
		assertThat(booking_details.get()).isNotNull();
	}
	
	@Test
	void getBookingHistory() {
		ResponseEntity<Optional<List<BookingDetails>>> response = controller.getBookingHistory("abc@gmail.com");
		Optional<List<BookingDetails>> resp_body = response.getBody();
		assertThat(resp_body).isNotEmpty();
		}
	
	@Test
	void bookingHistoryEmpty() {
		ResponseEntity<Optional<List<BookingDetails>>> response = controller.getBookingHistory("xyz@gmail.com");
		Integer resp_code = response.getStatusCodeValue();
		assertThat(resp_code).isEqualTo(200);
		}
	
	@Test
	void getPnrDetails() {
		ResponseEntity<Optional<BookingDetails>> response = controller.getBookingInfo("FMS0010");
		Optional<BookingDetails> resp_body = response.getBody();
		assertThat(resp_body).isNotEmpty();
	}
	
	@Test
	void getPassengerDetails() {
		ResponseEntity<Optional<List<PassengerDetails>>> response = controller.getPassengerDetails("FMS0010");
		Optional<List<PassengerDetails>> resp_body = response.getBody();
		assertThat(resp_body).isNotEmpty();
	}
	
	@Test
	void cancelTicket() {
		ResponseEntity<Integer> response = controller.cancelTicket("FMS0010");
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
		Optional<BookingDetails> resp = booking_repo.findByPnr("FMS0010");
		assertThat(resp.get().getStatus()).isEqualTo("cancelled");
	}
	
	@Test
	void cancelNotBookedTicket() {
		ResponseEntity<Integer> response = controller.cancelTicket("FMS0");
		assertThat(response.getStatusCodeValue()).isEqualTo(200);
	}
}
