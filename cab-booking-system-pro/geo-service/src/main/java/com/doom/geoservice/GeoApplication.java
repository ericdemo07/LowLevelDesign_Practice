package com.doom.geoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeoApplication {
    //quad tree for driver location should reside in driver location service
    //this service holds information for maps and locations and grids
    public static void main(String[] args) {
        SpringApplication.run(GeoApplication.class, args);
    }
}
