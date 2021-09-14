package com.parkinglot;

import com.parkinglot.readers.CommandLineReader;
import com.parkinglot.readers.InputFileReader;
import com.parkinglot.readers.ReaderClient;

import java.io.File;
import java.nio.file.Paths;

public class App {
    private static final String BASE_PATH = Paths.get("parking-lot-intermediate").toAbsolutePath().toString();

    public static void main(String[] args) throws Exception {
        args = new String[]{"file_inputs.txt"};
        if (args != null && args.length == 1) {
            final String filePath = BASE_PATH + File.separator + args[0];
            System.out.println("\n\nfilePath :" + filePath);
            if (!new File(filePath).isFile()) {
                throw new Exception("not a valid file");
            }

            new ReaderClient(new InputFileReader()).read(new String[]{filePath});
        }
        else {
            new ReaderClient(new CommandLineReader()).read();
        }
    }
}
