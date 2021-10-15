package com.doom.bookingservice.dao;

import com.doom.bookingservice.dao.models.Bookings;

import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Bookings, String> {
}
