package models;

import java.util.UUID;

public class Cab {
    private final UUID     id;
    private final String   driverLicenseNumber;
    private final String   vehicleNumber;
    private final String   color;
    private final String   brand;
    private final String   model;
    private final Location location;

    public Cab(UUID id,
               String driverLicenseNumber,
               String vehicleNumber,
               String color,
               String brand,
               String model,
               Location location) {
        this.id = id;
        this.driverLicenseNumber = driverLicenseNumber;
        this.vehicleNumber = vehicleNumber;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Location getLocation() {
        return location;
    }
}
