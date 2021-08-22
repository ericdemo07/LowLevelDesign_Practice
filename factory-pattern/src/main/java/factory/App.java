package src.main.java.factory;

public class App {

	public static void main(String... args) {
		Car car1 = CarFactory.getCar(CarType.FERRARI);
		Car car2 = CarFactory.getCar(CarType.LAMBORGHINI);

		System.out.println(car1.horsePower());
		System.out.println(car2.horsePower());
	}
}
