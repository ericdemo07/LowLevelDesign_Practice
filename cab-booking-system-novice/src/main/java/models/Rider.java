package models;

import java.util.UUID;

public class Rider {
    UUID   userId;
    String name;
    String contactNumber;

    public Rider(UUID userId, String name, String contactNumber) {
        this.userId = userId;
        this.name = name;
        this.contactNumber = contactNumber;
    }
}
