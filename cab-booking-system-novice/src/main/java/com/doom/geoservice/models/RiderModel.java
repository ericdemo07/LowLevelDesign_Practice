package com.doom.geoservice.models;

import java.util.UUID;

public class RiderModel {
    private       UUID   userId;
    private final String name;

    public RiderModel(String name) {
        this.name = name;
    }

    public RiderModel(UUID userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
