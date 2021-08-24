package intercepting_filter;

public class EngineTestFilter extends AbstractFilter {

    @Override
    public StringBuilder execute(Car car) {
        StringBuilder result = super.execute(car);

        if (car.getHorsePower() < 250 || car.getTorque() < 120) {
            result.append("\nEngine performance needs upgrade");
        }

        return result;
    }
}
