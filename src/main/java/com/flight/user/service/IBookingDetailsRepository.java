package com.flight.user.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.flight.user.entity.BookingDetails;

@Repository
public interface IBookingDetailsRepository extends JpaRepository<BookingDetails, Integer>{

	@Query("select b from BookingDetails b where b.email = :email")
	Optional<List<BookingDetails>> findByEmail(@Param("email") String email);
	
	@Query("select b from BookingDetails b where b.pnr = :pnr")
	Optional<BookingDetails> findByPnr(@Param("pnr") String pnr);
	
	@Transactional
	@Modifying
	@Query("update BookingDetails b set b.status = 'cancelled' where b.pnr = :pnr")
	void cancelTicket(@Param("pnr") String pnr);
}
