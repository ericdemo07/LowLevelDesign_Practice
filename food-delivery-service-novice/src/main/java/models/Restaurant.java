package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Restaurant {
    String      id;
    String      name;
    String      city;
    String      address;
    CuisineType cuisineType;
}
