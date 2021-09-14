package commandfactorytests;

import com.parkinglot.commandfactory.CommandFactory;
import com.parkinglot.commandfactory.ICommand;
import com.parkinglot.models.InputModel;
import com.parkinglot.storage.ParkingDataStore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnalyticsCommandToGetSlotNoFromRegNoTest {

    private static final int initialParkingSize = 1;

    @BeforeEach
    void setup() {
        ParkingDataStore.initializeInstance(initialParkingSize);
    }

    @Test
    void testAnalyticsCommandToGetSlotNo() {
        InputModel inputModel = new InputModel("park", new String[]{"KA-01-HH-3214", "White"});
        ICommand command = CommandFactory.getInstance(inputModel.getCommandAsString());
        command.execute(inputModel.getArgs());

        command = CommandFactory.getInstance("status");
        command.execute("");
        inputModel = new InputModel("slot_number_for_registration_number", new String[]{"KA-01-HH-3214"});
        command = CommandFactory.getInstance(inputModel.getCommandAsString());

        Assertions.assertTrue(command.validateInput(inputModel.getArgs()));
        Assertions.assertEquals("1", command.execute(inputModel.getArgs()));
    }
}
