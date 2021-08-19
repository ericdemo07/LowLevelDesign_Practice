
public class CarFactory {

	public static Car getCar(CarType type) {
		return type.getConstructor().get();
	}
}
