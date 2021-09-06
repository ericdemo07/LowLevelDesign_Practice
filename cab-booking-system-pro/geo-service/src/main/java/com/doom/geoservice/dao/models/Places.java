package com.doom.geoservice.dao.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Places {

    @Id
    private UUID id;

    private String name;

    private double latitude;

    private double longitude;

    private String category;

    private UUID grid_id;
}
