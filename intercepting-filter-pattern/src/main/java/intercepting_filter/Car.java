package intercepting_filter;

public class Car {
    private String model;

    private boolean frontDoorTested;

    private boolean bonnetTested;

    private int horsePower;

    private int torque;

    private int carbonEmission;

    private boolean driverSideLeft;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isFrontDoorTested() {
        return frontDoorTested;
    }

    public void setFrontDoorTested(boolean frontDoorTested) {
        this.frontDoorTested = frontDoorTested;
    }

    public boolean isBonnetTested() {
        return bonnetTested;
    }

    public void setBonnetTested(boolean bonnetTested) {
        this.bonnetTested = bonnetTested;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getCarbonEmission() {
        return carbonEmission;
    }

    public void setCarbonEmission(int carbonEmission) {
        this.carbonEmission = carbonEmission;
    }

    public boolean isDriverSideLeft() {
        return driverSideLeft;
    }

    public void setDriverSideLeft(boolean driverSideLeft) {
        this.driverSideLeft = driverSideLeft;
    }
}
