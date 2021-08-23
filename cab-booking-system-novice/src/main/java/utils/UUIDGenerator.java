package utils;

import java.util.UUID;
import java.util.function.Supplier;

public class UUIDGenerator {

    public Supplier<UUID> getUUID(){
        return UUID::randomUUID;
    }
}
