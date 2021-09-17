package com.doom.driverlocationservice.controllers;

import com.doom.driverlocationservice.models.Coordinates;
import com.doom.driverlocationservice.redis.RedisClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("driver-location-service")
public class DriverQueryController implements IDriverQueryController {

    private final RedisClient redisClient;

    private DriverQueryController() {
        this.redisClient = new RedisClient();
    }

    double[][] dirs = {{0, -0.01}, {0, 0.01}, {-0.01, 0}, {0.01, 0}};

    @Override
    public List<UUID> findDrivers(double latitude, double longitude) {

        List<UUID> list = redisClient.getMembers(buildCoordinates(latitude, longitude));
        int count = 1;

        while (list.size() < 2 && count <= 4) {
            for (double[] dir : dirs) {
                double newLat = latitude + (dir[0] * count), newLng = longitude + (dir[1] * count);

                List<UUID> tempList = redisClient.getMembers(buildCoordinates(newLat, newLng));
                list.addAll(tempList);
            }
            count++;
        }

        return list;
    }

    private Coordinates buildCoordinates(double latitude, double longitude) {
        Coordinates coordinates = new Coordinates();
        coordinates.setLatitude(latitude);
        coordinates.setLongitude(longitude);

        return coordinates;
    }
}
