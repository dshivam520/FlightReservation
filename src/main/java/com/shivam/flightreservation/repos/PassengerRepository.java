package com.shivam.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
