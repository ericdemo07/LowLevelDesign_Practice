package com.doom.geoservice.dao;

import com.doom.geoservice.dao.models.Places;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlaceRepository extends CrudRepository<Places, UUID> {
}
