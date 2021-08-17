package service;

import datastore.Storage;
import models.Car;

public class HandleParking {

	Storage storage;

	public HandleParking(int size) {
		storage = new Storage(size);
	}

	int park(Car car) {
		return storage.addCar(car);
	}

	int leave(int parkingSpot) {
		return storage.removeCar(parkingSpot);
	}
}
