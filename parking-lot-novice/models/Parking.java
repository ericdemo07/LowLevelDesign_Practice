package com.doom.geoservice.models;

public class Parking extends Car {

	int parkingSpot;

	public Parking(Car car, int parkingSpot) {
		super(car.registrationNumber, car.color);
		this.parkingSpot = parkingSpot;
	}
}
