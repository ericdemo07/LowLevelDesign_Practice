package datastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import models.Car;
import models.Parking;

public class Storage {
	int size;
	private final Map<Integer, Car> activeParkingMap;
	private PriorityQueue<Integer> availableParkingSpots;

	private List<Parking> dataWarehouse;

	public Storage(int size) {
		this.size = size;
		this.activeParkingMap = new HashMap<>();

		this.availableParkingSpots = new PriorityQueue<>((a, b) -> a - b);

		for (int i = 1; i <= size; i++) {
			availableParkingSpots.add(i);
		}

		this.dataWarehouse = new ArrayList<>();
	}

	public int addCar(Car car) {

		if (availableParkingSpots.isEmpty()) {
			return -1;
		}

		int parkingSpot = availableParkingSpots.poll();
		activeParkingMap.put(parkingSpot, car);

		dataWarehouse.add(new Parking(car, parkingSpot));

		return parkingSpot;
	}

	public int removeCar(int parkingSpot) {

		if (!activeParkingMap.containsKey(parkingSpot)) {
			return -1;
		}

		activeParkingMap.remove(parkingSpot);
		availableParkingSpots.add(parkingSpot);

		return parkingSpot;
	}
}
