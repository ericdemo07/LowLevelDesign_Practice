package strategy;

public class HillModeStrategy implements DriveModeStrategy{
    @Override
    public void execute() {
        System.out.println("Hill mode activated");
    }
}
