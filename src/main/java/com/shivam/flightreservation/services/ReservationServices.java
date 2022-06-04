package com.shivam.flightreservation.services;

import com.shivam.flightreservation.dto.ReservationRequest;
import com.shivam.flightreservation.entities.Reservation;

public interface ReservationServices {

	Reservation bookFlight(ReservationRequest request);

}
