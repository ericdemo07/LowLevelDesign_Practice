package intercepting_filter;

public class App {

    public static void main(String... args) {
        FilterManager filterManager = new FilterManager();

        filterManager.addFilter(new EngineTestFilter());
        filterManager.addFilter(new BodyTestFilter());
        filterManager.addFilter(new EUGovernmentCheckFilter());

        Car car = new Car();

        car.setModel("Lamborghini Diablo");
        car.setFrontDoorTested(false);
        car.setBonnetTested(false);
        car.setHorsePower(100);
        car.setTorque(480);
        car.setCarbonEmission(11);
        car.setDriverSideLeft(false);

        StringBuilder res = filterManager.filterRequest(car);

        System.out.println(res.toString());
    }
}
