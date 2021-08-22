package main.java.strategy;

public class SportsModeStrategy implements DriveModeStrategy {
    @Override
    public void execute() {
        System.out.println("Sports mode activated");
    }
}
