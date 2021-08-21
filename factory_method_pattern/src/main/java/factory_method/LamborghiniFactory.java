package src.main.java.factory_method;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LamborghiniFactory implements CarFactory {

	private static final Map<EngineType, LamborghiniModel> MAP;

	static {
		MAP = new EnumMap<>(EngineType.class);
	    Arrays.stream(EngineType.values()).forEach(type -> MAP.put(type, new LamborghiniModel(type)));
	}
	
	@Override
	public Car createCar(EngineType engineType) {
		return MAP.get(engineType);
	}
	
	@Override
	public String toString() {
		return "Lamborghini : ";
	}
}
