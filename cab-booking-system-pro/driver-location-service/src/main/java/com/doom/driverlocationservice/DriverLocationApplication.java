package com.doom.driverlocationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DriverLocationApplication {

    //this module handles driver current location and availability data
    public static void main(String[] args) {
        SpringApplication.run(DriverLocationApplication.class, args);
    }

}
