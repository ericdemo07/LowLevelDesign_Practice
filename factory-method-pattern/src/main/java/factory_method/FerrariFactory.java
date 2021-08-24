package factory_method;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class FerrariFactory implements CarFactory {

	private static final Map<EngineType, FerrariModel> MAP;

	static {
		MAP = new EnumMap<>(EngineType.class);
	    Arrays.stream(EngineType.values()).forEach(type -> MAP.put(type, new FerrariModel(type)));
	}

	@Override
	public Car createCar(EngineType engineType) {
		return MAP.get(engineType);
	}

	@Override
	public String toString() {
		return "Ferrari : ";
	}
}
