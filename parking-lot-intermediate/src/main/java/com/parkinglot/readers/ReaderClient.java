package com.parkinglot.readers;

public class ReaderClient {

    private final IReader reader;

    public ReaderClient(IReader reader) {
        this.reader = reader;
    }

    public void read(String... args) throws Exception {
        reader.read(args);
    }
}
