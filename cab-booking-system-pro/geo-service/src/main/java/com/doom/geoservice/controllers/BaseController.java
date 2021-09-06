package com.doom.geoservice.controllers;

import com.doom.geoservice.dao.PlaceRepository;
import com.doom.geoservice.dao.models.Places;
import com.doom.geoservice.models.Location;
import com.doom.geoservice.quadtree.QuadTreeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class BaseController implements IBaseController {

    private final QuadTreeService quadTreeService = QuadTreeService.getInstance();

    private final PlaceRepository placeRepository;

    @Autowired
    public BaseController(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @Override
    public boolean initialize() {
        Iterable<Places> places = placeRepository.findAll();
        List<Location> locationList = mapPlacesToLocation(places);

        quadTreeService.buildTree(locationList);
        quadTreeService.traverse();
        System.out.println("\n\n");
        quadTreeService.printLinkedList();

        return true;
    }

    private List<Location> mapPlacesToLocation(Iterable<Places> places) {
        return StreamSupport.stream(places.spliterator(), false)
                            .map(this::mapPlaceToLocation)
                            .collect(Collectors.toList());
    }

    private Location mapPlaceToLocation(Places place) {

        return Location.builder().locationUUID(place.getId())
                       .latitude(place.getLatitude())
                       .longitude(place.getLongitude())
                       .build();
    }
}
