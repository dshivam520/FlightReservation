package com.shivam.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivam.flightreservation.dto.ReservationRequest;
import com.shivam.flightreservation.entities.Flight;
import com.shivam.flightreservation.entities.Reservation;
import com.shivam.flightreservation.repos.FlightRepository;
import com.shivam.flightreservation.services.ReservationServices;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	ReservationServices reservationService;

	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight", flight);
		return "completeReservation";

	}

	@RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and the id is " + reservation.getId());
		return "reservationConfirmation";

	}

}
