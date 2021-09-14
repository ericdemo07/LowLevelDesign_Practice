package com.parkinglot.readers;

import com.parkinglot.commandfactory.CommandFactory;
import com.parkinglot.commandfactory.ICommand;
import com.parkinglot.models.InputModel;
import com.parkinglot.storage.ParkingDataStore;
import com.parkinglot.utils.StringUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class InputFileReader implements IReader {

    public void read(String... args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line = br.readLine();
            InputModel input = StringUtil.convertToInputModel(line);
            initializeDataStore(input);
            ICommand instance;
            line = br.readLine();

            while (line != null) {

                input = StringUtil.convertToInputModel(line);
                instance = CommandFactory.getInstance(input.getCommandAsString());

                if (instance.validateInput(input.getArgs())) {
                    String str = instance.execute(input.getArgs());
                    System.out.println(str);
                }
                line = br.readLine();
            }
        }
    }

    @Override
    public void initializeDataStore(InputModel input) {
        int size = Integer.parseInt(input.getArgs()[0]);
        ParkingDataStore.initializeInstance(size);
        System.out.println(String.format("Created a parking lot with 6 slots", size));
    }
}
