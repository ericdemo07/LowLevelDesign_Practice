package com.doom.geoservice.models;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Location {
    UUID locationUUID;

    //y-axis, x-axis
    double latitude, longitude;


    @Override
    public String toString() {
        return "\nlocationUUID :" + locationUUID + "  latitude :" + latitude + "  longitude :" + longitude;
    }
}
