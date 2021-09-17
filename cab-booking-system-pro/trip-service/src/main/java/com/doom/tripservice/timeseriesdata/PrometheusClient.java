package com.doom.tripservice.timeseriesdata;

import io.prometheus.client.Counter;

public class PrometheusClient {

    private static final Counter myCounter = Counter.build()
                                                    .name("CounterName")
                                                    .labelNames("status")
                                                    .help("Counter desc")
                                                    .register();


    private void process() {
        myCounter.labels();
    }
}
