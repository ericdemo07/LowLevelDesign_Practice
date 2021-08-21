package src.main.java.factory_method;

public class App {

	public static void main(String... args) {
		CarFactory car1 = new FerrariFactory();
		Car type1 = car1.createCar(EngineType.SIX_FOUR_LTR_TURBO_CHARGED);
		System.out.println(String.format("%s has %s", car1, type1));

		CarFactory car2 = new PorscheFactory();
		Car type2 = car2.createCar(EngineType.V12_NATURALLY_ASPIRATED);
		System.out.println(String.format("%s has %s", car2, type2));
	}
}
