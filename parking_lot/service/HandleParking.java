package service;

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
}
