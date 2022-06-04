package com.shivam.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.flightreservation.entities.Reservation;
import com.shivam.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {

	//private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

	@Autowired
	ReservationRepository reservationRepository;

	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		return reservationRepository.findById(id).get();

	}

//	@RequestMapping("/reservations")
//	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
//		LOGGER.info("Inside updateReservation() for " + request);
//		Reservation reservation = reservationRepository.findById(request.getId()).get();
//		reservation.setNumberOfBags(request.getNumberOfBags());
//		reservation.setCheckedIn(request.getCheckedIn());
//		LOGGER.info("Saving Reservation");
//		return reservationRepository.save(reservation);
//
//	}

}
