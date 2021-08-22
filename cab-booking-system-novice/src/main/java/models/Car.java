package models;

public class Car {
    String number;
    String color;
    String brand;
    String model;

    Location location;

    public Car(String number, String color, String brand, String model, Location location) {
        this.number = number;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.location = location;
    }
}
