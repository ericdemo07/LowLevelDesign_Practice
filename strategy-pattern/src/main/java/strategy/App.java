package strategy;

public class App {
    public static void main(String... args) {
        Drive drive = new Drive(new HillModeStrategy());
        drive.execute();

        drive.changeStrategy(new EconomyModeStrategy());
        drive.execute();
    }
}
