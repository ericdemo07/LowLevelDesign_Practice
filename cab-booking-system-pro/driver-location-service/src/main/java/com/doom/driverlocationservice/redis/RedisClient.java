package com.doom.driverlocationservice.redis;

import com.doom.driverlocationservice.models.Coordinates;
import com.doom.driverlocationservice.models.DriverLocationModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

import redis.clients.jedis.Jedis;

public class RedisClient {
    private final ObjectMapper objectMapper;
    private final Jedis        jedis;

    public RedisClient() {
        this.jedis = new Jedis();
        this.objectMapper = new ObjectMapper();
    }

    public void updateDriverAvailability(UUID driverId, boolean isAvailable) throws JsonProcessingException {
        String driverLocationModelAsString = getValue(driverId.toString());

        DriverLocationModel driverLocationModel
                = objectMapper.readValue(driverLocationModelAsString, DriverLocationModel.class);

        driverLocationModel.setAvailable(isAvailable);

        String currentGrid = driverLocationModel.getCurrentGridId();

        removeDriverFromGrid(currentGrid, driverId.toString());
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

        String currentGridId = objToString(driverCoordinates);
        addDriverToGrid(currentGridId, driverId.toString());

        driverLocationModel.setCurrentGridId(objToString(driverCoordinates));
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

    private String objToString(Object o) throws JsonProcessingException {
        return objectMapper.writeValueAsString(o);
    }

    private void updateDriverLocationDetails(DriverLocationModel model) throws JsonProcessingException {
        String driverLocationModelAsString = objToString(model);
        jedis.set(model.getDriverId().toString(), driverLocationModelAsString);
    }
}
