package intercepting_filter;

public class BodyTestFilter extends AbstractFilter {

    @Override
    public StringBuilder execute(Car car) {
        StringBuilder result = super.execute(car);

        if (!car.isFrontDoorTested() || car.isBonnetTested()) {
            result.append("\nBody test need to be conducted again");
        }

        return result;
    }
}
