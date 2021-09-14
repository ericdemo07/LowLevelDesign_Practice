package strategy;

public class Drive {
    private DriveModeStrategy driveModeStrategy;

    public Drive(DriveModeStrategy driveModeStrategy) {
        this.driveModeStrategy = driveModeStrategy;
    }

    public void changeStrategy(DriveModeStrategy driveModeStrategy) {
        this.driveModeStrategy = driveModeStrategy;
    }

    public void execute(){
        this.driveModeStrategy.execute();
    }
}
