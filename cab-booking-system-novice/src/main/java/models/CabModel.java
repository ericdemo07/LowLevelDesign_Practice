package models;

import java.util.UUID;

public class CabModel {
    private       UUID            id;
    private final String          vehicleNumber;
    private       CoordinateModel coordinateModel;
    private       boolean         isAvailable;

    public CabModel(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.isAvailable = false;
    }

    public CabModel(UUID id, String vehicleNumber) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.isAvailable = false;
    }

    public UUID getId() {
        return id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setCoordinateModel(CoordinateModel coordinateModel) {
        this.coordinateModel = coordinateModel;
    }

    public CoordinateModel getCoordinateModel() {
        return coordinateModel;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "CabModel{" +
                "id=" + id +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", coordinateModel=" + coordinateModel +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
