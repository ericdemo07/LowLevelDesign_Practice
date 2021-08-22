package models;

import java.util.UUID;

public class Driver {
    UUID   userId;
    String licenseNumber;
    String name;
    int    experience;

    public Driver(UUID userId, String licenseNumber, String name, int experience) {
        this.userId = userId;
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.experience = experience;
    }
}
