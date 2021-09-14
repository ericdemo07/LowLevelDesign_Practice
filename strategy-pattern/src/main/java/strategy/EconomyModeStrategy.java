package strategy;

public class EconomyModeStrategy implements DriveModeStrategy {
    @Override
    public void execute() {
        System.out.println("Economy mode activated");
    }
}
