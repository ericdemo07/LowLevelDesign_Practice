package authentication_interceptor;

import com.doom.geoservice.models.user_step_builder.User;

public class BaseUserFilter extends AbstractFilter<User> {

    @Override
    public StringBuilder execute(User user) {
        StringBuilder result = super.execute(user);

        if (user.getFirstName().isEmpty() || user.getLastName().isEmpty()) {
            result.append("\nFirst name and last name are required");
        }

        if (!user.isEmailVerified() && !user.isPhoneNumberVerified()) {
            result.append("\nOne of phone or email has to be verified");
        }

        return result;
    }
}
