package com.doom.tripservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TripServiceApplication {
    //handles cab choosing, booking, tracking trip, trip history
    public static void main(String[] args) {
        SpringApplication.run(TripServiceApplication.class, args);
    }

}
