package com.doom.ratelimiternovice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Datastore {
    private static final Map<String, Integer> map;

    private static final int limit;

    static {
        map = Collections.synchronizedMap(new HashMap<>());

        List<String> clients = Arrays.asList("clientA", "clientB", "clientC", "clientD");

        for (String client : clients) {
            map.put(client, 0);
        }

        limit = 4;
    }

    public boolean isAllowed(String clientId) {
        return map.getOrDefault(clientId, limit + 1) < limit;
    }

    public void increment(String clientId) {
        map.put(clientId, map.getOrDefault(clientId, 0) + 1);
    }

    public void reset() {
        map.replaceAll((k, v) -> 0);
        System.out.println("cache reset complete");
    }
}
