package datastore;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import lombok.Builder;

public class UserDatastore implements ICRUDOperations<models.User> {
    private final List<User> users;

    public UserDatastore() {
        users = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public String add(models.User item) {
        final String id = UUID.randomUUID().toString();

        User user1 = User.builder()
                         .id(id)
                         .name(item.getName())
                         .email(item.getEmail())
                         .address(item.getAddress())
                         .city(item.getCity())
                         .updatedAt(OffsetDateTime.now())
                         .createdAt(OffsetDateTime.now())
                         .build();

        users.add(user1);
        System.out.println(users);
        return id;
    }

    @Override
    public models.User get(String id) {
        return users.stream().filter(user -> user.id.equals(id)).map(this::mapDBRecordToObject).findFirst().get();
    }

    private models.User mapDBRecordToObject(User user) {
        return new models.User(user.id, user.name, user.email, user.city, user.address);
    }

    @Override
    public String update(models.User item) {
        final String id = item.getId();
        int i;

        for (i = 0; i < users.size(); i++) {
            if (users.get(i).id.equals(id)) {
                break;
            }
        }

        User user1 = User.builder()
                         .id(id)
                         .name(item.getName())
                         .email(item.getEmail())
                         .address(item.getAddress())
                         .city(item.getCity())
                         .updatedAt(OffsetDateTime.now())
                         .createdAt(OffsetDateTime.now())
                         .build();

        users.set(i, user1);

        return id;
    }

    @Override
    public String delete(String id) {
        users.removeIf(user -> user.id.equals(id));

        return id;
    }
}

@Builder
class User {
    String         id;
    String         name;
    String         email;
    String         address;
    String         city;
    OffsetDateTime updatedAt;
    OffsetDateTime createdAt;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", updatedAt=" + updatedAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
