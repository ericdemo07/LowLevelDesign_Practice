package authentication_interceptor;

import models.cab_builder.Cab;

public class BaseCabFilter extends AbstractFilter<Cab> {

    @Override
    public StringBuilder execute(Cab cab) {
        StringBuilder result = super.execute(cab);

        if (!cab.isPapersVerified()) {
            result.append("\nCab papers are not verified");
        }

        return result;
    }
}
