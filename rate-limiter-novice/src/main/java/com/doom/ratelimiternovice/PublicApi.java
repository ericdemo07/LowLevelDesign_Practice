package com.doom.ratelimiternovice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
public class PublicApi {

    private final Datastore datastore;

    public PublicApi() {
        datastore = new Datastore();
        reset();
    }

    @GetMapping("request")
    ResponseEntity request(@RequestParam("client-id") String clientId) {
        if (datastore.isAllowed(clientId)) {
            datastore.increment(clientId);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.TOO_MANY_REQUESTS);
    }

    private void reset() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(this::process, 10, 10, TimeUnit.SECONDS);
    }

    private void process() {
        datastore.reset();
    }
}
