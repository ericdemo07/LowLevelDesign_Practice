package com.doom.driverlocationservice.redis;

import com.doom.driverlocationservice.models.Coordinates;
import com.doom.driverlocationservice.models.DriverAvailabilityModel;
import com.doom.driverlocationservice.models.DriverLocationModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DecimalFormat;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import redis.clients.jedis.Jedis;

public class RedisClient {
    private static final ObjectMapper  objectMapper;
    private static final Jedis         jedis;
    private static final DecimalFormat decimalFormat;
    private static final String        gridIdFormat;

    static {
        jedis = new Jedis();
        objectMapper = new ObjectMapper();
        decimalFormat = new DecimalFormat("#.##");
        gridIdFormat = "%s:%s";
    }

    public void updateDriverAvailability(UUID driverId,
                                         DriverAvailabilityModel driverAvailability) throws JsonProcessingException {

        String driverLocationModelAsString = getValue(driverId.toString());

        if (driverLocationModelAsString == null || driverLocationModelAsString.isEmpty()) {
            System.out.println("\n\nhell");
            return;
        }

        DriverLocationModel driverLocationModel
                = objectMapper.readValue(driverLocationModelAsString, DriverLocationModel.class);

        boolean isAvailable = driverAvailability.getIsAvailable();

        driverLocationModel.setAvailable(isAvailable);

        if (isAvailable) {
            String currentGrid = buildGridId(driverAvailability.getCurrentCoordinates());
            addDriverToGrid(currentGrid, driverId.toString());
        }
        else {
            String currentGrid = driverLocationModel.getCurrentGridId();
            removeDriverFromGrid(currentGrid, driverId.toString());
        }

        updateDriverLocationDetails(driverLocationModel);
    }

    public void updateDriverLocation(UUID driverId, Coordinates driverCoordinates) throws JsonProcessingException {
        String driverLocationModelAsString = getValue(driverId.toString());

        DriverLocationModel driverLocationModel = new DriverLocationModel();
        driverLocationModel.setDriverId(driverId);

        if (driverLocationModelAsString != null && !driverLocationModelAsString.isEmpty()) {
            driverLocationModel = objectMapper.readValue(driverLocationModelAsString, DriverLocationModel.class);

            if (!driverLocationModel.isAvailable()) {
                return;
            }

            String previousGridId = driverLocationModel.getCurrentGridId();
            driverLocationModel.setPreviousGridId(previousGridId);

            removeDriverFromGrid(previousGridId, driverId.toString());
        }

        driverLocationModel.setAvailable(true);

        String currentGridId = buildGridId(driverCoordinates);
        System.out.println("hell :" + currentGridId + " ||| driverId :" + driverId.toString());
        addDriverToGrid(currentGridId, driverId.toString());

        driverLocationModel.setCurrentGridId(currentGridId);
        driverLocationModel.setPosition(driverCoordinates);

        updateDriverLocationDetails(driverLocationModel);
    }

    private String getValue(String key) {
        return jedis.get(key);
    }

    private void addDriverToGrid(String gridCoordinates, String driverId) {
        jedis.sadd(gridCoordinates, driverId);
    }

    private void removeDriverFromGrid(String gridCoordinates, String driverId) {
        jedis.srem(gridCoordinates, driverId);
    }

    private String buildGridId(Coordinates coordinates) {
        String latitudeAsString = decimalFormat.format(coordinates.getLatitude());
        String longitudeAsString = decimalFormat.format(coordinates.getLongitude());

        return String.format(gridIdFormat, latitudeAsString, longitudeAsString);
    }

    private String objToString(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(o);
    }

    private void updateDriverLocationDetails(DriverLocationModel model) throws JsonProcessingException {
        String driverLocationModelAsString = objToString(model);
        System.out.println("\n\n model.getDriverId().toString() :" + model.getDriverId().toString());
        jedis.set(model.getDriverId().toString(), driverLocationModelAsString);
    }

    public List<UUID> getMembers(Coordinates coordinates) {
        String coordinatesAsString = buildGridId(coordinates);
        return jedis.smembers(coordinatesAsString).stream().map(UUID::fromString).collect(Collectors.toList());
    }
}
