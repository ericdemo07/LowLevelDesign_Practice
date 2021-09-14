package com.parkinglot.readers;

import com.parkinglot.commandfactory.CommandFactory;
import com.parkinglot.commandfactory.ICommand;
import com.parkinglot.models.InputModel;
import com.parkinglot.storage.ParkingDataStore;
import com.parkinglot.utils.StringUtil;

import java.util.Scanner;

public class CommandLineReader implements IReader {

    private static final String EXIT_COMMAND = "exit";

    public void read(String... args) {
        final Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        InputModel input = StringUtil.convertToInputModel(s);
        initializeDataStore(input);

        ICommand instance;
        while (true) {
            s = in.nextLine();
            if(EXIT_COMMAND.equals(s)){
                return;
            }
            input = StringUtil.convertToInputModel(s);
            instance = CommandFactory.getInstance(input.getCommandAsString());

            if (instance.validateInput(input.getArgs())) {
                String str = instance.execute(input.getArgs());
                System.out.println(str);
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
