package authentication_interceptor;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import models.user_step_builder.User;

public class AdvanceUserFilter extends AbstractFilter<User> {

    private final Set<String> eligibleCountries = new ConcurrentSkipListSet<>(Arrays.asList("US", "FR"));

    @Override
    public StringBuilder execute(User user) {
        StringBuilder result = super.execute(user);

        if (!eligibleCountries.contains(user.getCountry())) {
            result.append("\nCountry not eligible");
        }

        return result;
    }
}
