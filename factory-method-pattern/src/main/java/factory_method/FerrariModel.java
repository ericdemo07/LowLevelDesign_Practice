package factory_method;

public class FerrariModel implements Car {

	private final EngineType engineType;

	public FerrariModel(EngineType engineType) {
		super();
		this.engineType = engineType;
	}

	@Override
	public EngineType getCarType() {
		return engineType;
	}

	@Override
	public String toString() {
		return "A Ferrari object of :" + engineType;
	}
}
