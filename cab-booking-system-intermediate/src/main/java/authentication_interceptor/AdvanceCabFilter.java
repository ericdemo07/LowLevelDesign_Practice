package authentication_interceptor;

import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import com.doom.geoservice.models.cab_builder.Cab;

public class AdvanceCabFilter extends AbstractFilter<Cab> {

    private final Set<String> eligibleCountries = new ConcurrentSkipListSet<>(Arrays.asList("US", "FR"));

    @Override
    public StringBuilder execute(Cab cab) {
        StringBuilder result = super.execute(cab);

        if (cab.getMileage() < 20) {
            result.append("\nCab mileage is lower than allowed");
        }

        if (cab.getManufacturingYear() < 2010) {
            result.append("\nCab is older than allowed");
        }

        return result;
    }
}
