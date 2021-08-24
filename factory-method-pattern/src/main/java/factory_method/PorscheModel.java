package factory_method;

public class PorscheModel implements Car {

	private final EngineType engineType;

	public PorscheModel(EngineType engineType) {
		super();
		this.engineType = engineType;
	}

	@Override
	public EngineType getCarType() {
		return engineType;
	}

	@Override
	public String toString() {
		return "A Porsche object of :" + engineType;
	}
}
