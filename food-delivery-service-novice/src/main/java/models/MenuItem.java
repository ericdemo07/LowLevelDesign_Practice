package models;

import constants.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuItem {
    String   id;
    FoodItem foodItem;
    double   price;
    String   description;
}
