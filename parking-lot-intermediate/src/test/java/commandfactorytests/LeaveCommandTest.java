package commandfactorytests;

import com.parkinglot.commandfactory.CommandFactory;
import com.parkinglot.commandfactory.ICommand;
import com.parkinglot.models.InputModel;
import com.parkinglot.storage.ParkingDataStore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LeaveCommandTest {

    private static final int initialParkingSize = 1;

    @BeforeAll
    static void setup() {
        ParkingDataStore.initializeInstance(initialParkingSize);
    }

    @Test
    void testLeaveCommand() {
        InputModel inputModel = new InputModel("leave", new String[]{"1"});
        ICommand command = CommandFactory.getInstance(inputModel.getCommandAsString());
        command.execute(inputModel.getArgs());

        inputModel = new InputModel("leave", new String[]{"1"});
        command = CommandFactory.getInstance(inputModel.getCommandAsString());

        Assertions.assertTrue(command.validateInput(inputModel.getArgs()));
        Assertions.assertEquals("Slot number 1 is free", command.execute(inputModel.getArgs()));
    }
}
