package datastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

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

	public List<String> getRegistrationNumberOfAllCarsOfColor(String color) {
		return dataWarehouse.stream().filter(e -> color.equals(e.getColor())).map(e -> e.getRegistrationNumber())
				.collect(Collectors.toList());
	}

	public int getSlotNumberByCarNumber(String carNumber) {
		int slot = -1;

		for (Map.Entry<Integer, Car> entry : activeParkingMap.entrySet()) {
			if (carNumber.equals(entry.getValue().getRegistrationNumber())) {
				slot = entry.getKey();
				break;
			}
		}

		return slot;
	}

	public List<Integer> getSlotNumbersByColor(String carColor) {
		List<Integer> list = new ArrayList<>();

		for (Map.Entry<Integer, Car> entry : activeParkingMap.entrySet()) {
			if (carColor.equals(entry.getValue().getColor())) {
				list.add(entry.getKey());
			}
		}

		return list;
	}
}
