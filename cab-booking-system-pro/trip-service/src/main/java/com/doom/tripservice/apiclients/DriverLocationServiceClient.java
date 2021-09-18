package com.doom.tripservice.apiclients;

import com.doom.tripservice.models.Coordinates;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class DriverLocationServiceClient {

    private final RestTemplate restTemplate;

    public DriverLocationServiceClient() {
        this.restTemplate = new RestTemplate();
    }

    private static final String FIND_DRIVERS_API = "localhost:50005/driver-location-service/find-drivers?latitude=%s&longitude=%s";

    public List<UUID> getNearByDrivers(Coordinates coordinates) {

        final String url = String.format(FIND_DRIVERS_API, coordinates.getLatitude(), coordinates.getLongitude());
        final UUID[] response = restTemplate.getForObject(url, UUID[].class);

        return Arrays.asList(response);
    }
}
