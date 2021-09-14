package com.parkinglot.readers;

import com.parkinglot.models.InputModel;

public interface IReader {
    void read(String... args) throws Exception;

    void initializeDataStore(InputModel input);
}
