package src.main.java.factory;
import java.util.function.Supplier;

public enum CarType {
	FERRARI(Ferrari::new), LAMBORGHINI(Lamborghini::new), PORSCHE(Porsche::new);

	private final Supplier<Car> constructor;

	private CarType(Supplier<Car> constructor) {
		this.constructor = constructor;
	}

	public Supplier<Car> getConstructor() {
		return constructor;
	}
}
