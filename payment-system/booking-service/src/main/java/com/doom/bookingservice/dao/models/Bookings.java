package com.doom.bookingservice.dao.models;

import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Bookings {
    @Id
    private String id;

    private String itemId;

    private String userId;

    private OffsetDateTime createdAt;
}
