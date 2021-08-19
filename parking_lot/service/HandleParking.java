package service;

import java.util.List;

import datastore.Storage;
import models.Car;

public class HandleParking {

	private final Storage storage;

	public HandleParking(int size) {
		storage = new Storage(size);
	}

	public int park(Car car) {
		return storage.addCar(car);
	}

	public int remove(int parkingSpot) {
		return storage.removeCar(parkingSpot);
	}
	
	public List<String> getRegistrationNumberOfAllCarsOfColor(String color){
		return storage.getRegistrationNumberOfAllCarsOfColor(color);
	}
	
	public int getSlotNumberByCarNumber(String carNumber){
		return storage.getSlotNumberByCarNumber(carNumber);
	}
	
	public List<Integer> getSlotNumbersByColor(String color){
		return storage.getSlotNumbersByColor(color);
	}
}
