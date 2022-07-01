package com.flight.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.flight.user.entity.BookingDetails;
import com.flight.user.entity.PassengerDetails;

@Repository
public interface IPassengerDetailsRepository extends JpaRepository<PassengerDetails, String>{

	@Query("select p from PassengerDetails p where p.pnr = :pnr")
	Optional<List<PassengerDetails>> findByPnr(@Param("pnr") String pnr);
	
}
