import java.util.UUID;

import models.user_step_builder.User;
import models.user_step_builder.UserStepBuilder;

public class App {

    public static void main(String... args) {
        User user = UserStepBuilder.newBuilder()
                                   .uuid(UUID.randomUUID())
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

        System.out.println("\n\nuser :"+user);
    }
}
