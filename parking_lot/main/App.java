package main;

import java.util.Arrays;
import java.util.Scanner;

import models.Car;
import service.HandleParking;

public class App {

	private static final String ESCAPE_KEYWORD = "quit";
	private static final String PARK_KEYWORD = "park";
	private static final String REMOVE_KEYWORD = "leave";

	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter parking size");

		int parkingSize = scanner.nextInt();
		HandleParking handleParking = new HandleParking(parkingSize);

		String next = scanner.nextLine();
		System.out.println("next :" + next);
		while (!ESCAPE_KEYWORD.equals(next)) {
			if (next.startsWith(PARK_KEYWORD)) {
				String[] arr = next.split(" ");
				System.out.println(Arrays.toString(arr));
				Car car = new Car(arr[1], arr[2]);
				handleParking.park(car);
			} else if (next.startsWith(REMOVE_KEYWORD)) {
				String[] arr = next.split(" ");
				handleParking.remove(Integer.valueOf(arr[1]));
			} else {
				System.out.println("wrong keyword");
			}
			next = scanner.nextLine();
		}
	}
}
