package main;

import java.util.List;
import java.util.Scanner;

import com.doom.geoservice.models.Car;
import service.HandleParking;
import utils.Constants;


public class ParkingController {
	private final HandleParking handleParking;
	private final Scanner scanner;

	public ParkingController() {
		scanner = new Scanner(System.in);

		System.out.println("Welcome to Futura Parking, Enter parkinglot size");
		int parkingLotSize = scanner.nextInt();
		handleParking = new HandleParking(parkingLotSize);

		process();
	}

	private String[] getNextInput() {
		return scanner.nextLine().split(" ");
	}

	private void process() {
		String[] input = getNextInput();

		while (!Constants.ESCAPE_KEYWORD.equals(input[0])) {
			action(input);
			System.out.println("\n");
			input = getNextInput();
		}
	}

	private void action(String[] input) {
		switch (input[0]) {
		case Constants.PARK_KEYWORD:
			final Car car = new Car(input[1], input[2]);
			int parkingSpot = handleParking.park(car);
			if (parkingSpot == -1) {
				System.out.println("PARKING NOT AVAILABLE");
			} else {
				System.out.println("PARKED IN SPOT :" + String.valueOf(parkingSpot));
			}
			break;
		case Constants.REMOVE_KEYWORD:
			parkingSpot = Integer.valueOf(input[1]);
			int response = handleParking.remove(parkingSpot);
			if (response == -1) {
				System.out.println("NO CAR FOUND IN PARKING SPOT");
			} else {
				System.out.println("SLOT NO. " + String.valueOf(response) + " IS FREE");
			}
			break;
		case Constants.ANALYTICS1_KEYWORD:
			List<String> list = handleParking.getRegistrationNumberOfAllCarsOfColor(input[1]);
			if (list.isEmpty()) {
				System.out.println("NO CARS FOUND FOR GIVEN COLOR");
			} else {
				System.out.println(list);
			}
			break;
		case Constants.ANALYTICS2_KEYWORD:
			int slotNumber = handleParking.getSlotNumberByCarNumber(input[1]);
			if (slotNumber == -1) {
				System.out.println("CAR NOT FOUND");
			} else {
				System.out.println("SLOT NUMBER IS :" + slotNumber);
			}
			break;
		case Constants.ANALYTICS3_KEYWORD:
			List<Integer> slots = handleParking.getSlotNumbersByColor(input[1]);
			if (slots.isEmpty()) {
				System.out.println("NO CARS FOUND FOR GIVEN COLOR");
			} else {
				System.out.println(slots);
			}
			break;
		default:
			break;
		}
	}
}
