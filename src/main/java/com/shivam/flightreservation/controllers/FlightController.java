package com.shivam.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shivam.flightreservation.entities.Flight;
import com.shivam.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	FlightRepository flightRepository;
	
	@RequestMapping("findFlights")
	public String findFlights(@RequestParam("form") String from,@RequestParam("to") String to,@RequestParam("departureDate") @DateTimeFormat(pattern = "MM-DD-YYYY") Date departureDate, ModelMap modelMap) {
		List<Flight> flights = flightRepository.findFlights(from, to, departureDate);		modelMap.addAttribute("flights", flights);
		return "displayFlights";
		
	}

}
