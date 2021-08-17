package main;

import java.util.Scanner;

import service.HandleParking;

public class App {
	public static void main(String... args) {		
		Scanner scanner  = new Scanner(System.in);
		
		System.out.println("Enter parking size");
		
		int parkingSize = scanner.nextInt();
		HandleParking handleParking = new HandleParking(parkingSize);
		
		
	}
}
