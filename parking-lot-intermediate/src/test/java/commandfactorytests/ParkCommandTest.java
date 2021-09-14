package commandfactorytests;

import com.parkinglot.commandfactory.CommandFactory;
import com.parkinglot.commandfactory.ICommand;
import com.parkinglot.models.InputModel;
import com.parkinglot.storage.ParkingDataStore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ParkCommandTest {

    private static final int initialParkingSize = 1;

    @BeforeAll
    static void setup() {
        ParkingDataStore.initializeInstance(initialParkingSize);
    }

    @Test
    void testParkCommand() {
        InputModel inputModel = new InputModel("park", new String[]{"KA-01-HH-1234", "White"});
        ICommand command = CommandFactory.getInstance(inputModel.getCommandAsString());

        Assertions.assertTrue(command.validateInput(inputModel.getArgs()));
        Assertions.assertEquals("Allocated slot number: 1", command.execute(inputModel.getArgs()));
    }

    @Test
    void testParkCommandWhenLotIsFull() {
        InputModel inputModel = new InputModel("park", new String[]{"KA-01-HH-3214", "White"});
        ICommand command = CommandFactory.getInstance(inputModel.getCommandAsString());
        command.execute(inputModel.getArgs());

        inputModel = new InputModel("park", new String[]{"KA-01-HH-1234", "White"});
        command = CommandFactory.getInstance(inputModel.getCommandAsString());
        Assertions.assertTrue(command.validateInput(inputModel.getArgs()));
        Assertions.assertEquals("Sorry, parking lot is full", command.execute(inputModel.getArgs()));
    }
}
