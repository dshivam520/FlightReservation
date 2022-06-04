package com.shivam.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shivam.flightreservation.dto.ReservationRequest;
import com.shivam.flightreservation.entities.Flight;
import com.shivam.flightreservation.entities.Passenger;
import com.shivam.flightreservation.entities.Reservation;
import com.shivam.flightreservation.repos.FlightRepository;
import com.shivam.flightreservation.repos.PassengerRepository;
import com.shivam.flightreservation.repos.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationServices {

	

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {

		// Make Payment

		Long flightId = request.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();

		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		Reservation savedReservation = reservationRepository.save(reservation);
		return savedReservation;
		
	}

}
