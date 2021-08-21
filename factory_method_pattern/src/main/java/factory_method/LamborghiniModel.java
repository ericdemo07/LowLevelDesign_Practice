package src.main.java.factory_method;

public class LamborghiniModel implements Car {

	private final EngineType engineType;

	public LamborghiniModel(EngineType engineType) {
		super();
		this.engineType = engineType;
	}

	@Override
	public EngineType getCarType() {
		return engineType;
	}
	
	@Override
	public String toString() {
		return "A Lamborghini object of :" + engineType;
	}
}
