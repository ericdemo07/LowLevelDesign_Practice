package datastore;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import constants.FoodItem;
import lombok.Builder;

public class FoodMenuDataStore implements ICRUDOperations<models.MenuItem> {

    private final List<MenuItem> menuItems;

    public FoodMenuDataStore() {
        menuItems = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public String add(models.MenuItem item) {
        final String id = UUID.randomUUID().toString();

        MenuItem menuItem1 = MenuItem.builder()
                                     .id(id)
                                     .foodItem(item.getFoodItem())
                                     .price(item.getPrice())
                                     .description(item.getDescription())
                                     .updatedAt(OffsetDateTime.now())
                                     .createdAt(OffsetDateTime.now())
                                     .build();

        menuItems.add(menuItem1);
        System.out.println(menuItems);
        return id;
    }

    @Override
    public models.MenuItem get(String id) {
        return menuItems.stream()
                        .filter(menuItem -> menuItem.id.equals(id))
                        .map(this::mapDBRecordToObject)
                        .findFirst()
                        .get();
    }

    private models.MenuItem mapDBRecordToObject(MenuItem menuItem) {
        return new models.MenuItem(menuItem.id, menuItem.foodItem, menuItem.price, menuItem.description);
    }

    @Override
    public String update(models.MenuItem item) {
        final String id = item.getId();

        int i;
        for (i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).id.equals(id)) {
                break;
            }
        }

        MenuItem menuItem1 = MenuItem.builder()
                                     .id(id)
                                     .foodItem(item.getFoodItem())
                                     .price(item.getPrice())
                                     .description(item.getDescription())
                                     .updatedAt(OffsetDateTime.now())
                                     .createdAt(OffsetDateTime.now())
                                     .build();

        menuItems.set(i, menuItem1);

        return id;
    }

    @Override
    public String delete(String id) {
        menuItems.removeIf(menuItem -> menuItem.id.equals(id));

        return id;
    }

}

@Builder
class MenuItem {
    String         id;
    FoodItem       foodItem;
    double         price;
    String         description;
    OffsetDateTime updatedAt;
    OffsetDateTime createdAt;

    @Override
    public String toString() {
        return "MenuItem{" +
                "id='" + id + '\'' +
                ", foodItem=" + foodItem +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
