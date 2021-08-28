package utils;

import java.util.UUID;

import models.Coordinates;
import models.cab_builder.Cab;
import models.user_step_builder.User;
import models.user_step_builder.UserStepBuilder;

public class Dummies {

    public static User getDummyUser() {

        return UserStepBuilder.newBuilder()
                              .uuid(UUID.fromString("6a2acde3-9253-4bd2-bd49-c3749bf604af"))
                              .fistName("Ayush")
                              .lastName("Shukla")
                              .email("a@a.com")
                              .isValidEmail(true)
                              .country("US")
                              .stateNotAvailable()
                              .address("aaa,111")
                              .address("aaa1,222")
                              .noMoreAddress()
                              .createdAt(1111111)
                              .build();
    }

    public static Cab getDummyCab() {

        return new Cab.Builder()
                .cabUUID(UUID.randomUUID())
                .brand("Volkswagen")
                .model("Polo")
                .mileage(22)
                .manufacturingYear(2012)
                .papersVerified(true)
                .coordinates(new Coordinates(1, 2))
                .build();
    }
}
