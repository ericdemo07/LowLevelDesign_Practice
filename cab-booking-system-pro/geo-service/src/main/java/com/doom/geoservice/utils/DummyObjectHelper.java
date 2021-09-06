package com.doom.geoservice.utils;

import com.doom.geoservice.models.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class DummyObjectHelper {
    public List<Location> dummyLocations() {
        List<Location> list = new ArrayList<>();

        double latStart = 1.00, lngStart = 3.00;
        Random random = new Random();
        for (int i = 0; i < 11; i++) {
            int x = random.nextInt(16);
            int y = random.nextInt(16);
            if (x % 2 == 0 && y % 2 == 0) {
                list.add(dummyLocation(latStart + random.nextInt(16), lngStart + random.nextInt(18)));
            }
            else if (x % 2 == 0) {
                list.add(dummyLocation(latStart - random.nextInt(16), lngStart + random.nextInt(18)));
            }
            else if (y % 2 == 0) {
                list.add(dummyLocation(latStart + random.nextInt(16), lngStart - random.nextInt(18)));
            }
            else {
                list.add(dummyLocation(latStart - random.nextInt(16), lngStart - random.nextInt(18)));
            }
        }

        return list;
    }

    private Location dummyLocation(double latitude, double longitude) {
        return Location.builder()
                       .locationUUID(UUID.randomUUID())
                       .latitude(latitude)
                       .longitude(longitude)
                       .build();
    }
}
