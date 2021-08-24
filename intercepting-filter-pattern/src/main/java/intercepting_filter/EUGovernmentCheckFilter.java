package intercepting_filter;

public class EUGovernmentCheckFilter extends AbstractFilter {

    @Override
    public StringBuilder execute(Car car) {
        StringBuilder result = super.execute(car);

        if (car.getCarbonEmission() > 22 || !car.isDriverSideLeft()) {
            result.append("\nNot meeting EU government guidelines");
        }

        return result;
    }
}
