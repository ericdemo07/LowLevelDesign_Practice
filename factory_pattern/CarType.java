
public enum CarType {
	FERRARI(new Ferrari()), LAMBORGHINI(new Lamborghini()), PORSCHE(new Porsche());

	private final Car constructor;

	private CarType(Car constructor) {
		this.constructor = constructor;
	}

	public Car getConstructor() {
		return constructor;
	}
}
