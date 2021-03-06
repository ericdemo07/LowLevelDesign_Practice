package com.doom.geoservice.models.cab_builder;

import java.util.UUID;

import com.doom.geoservice.models.Coordinates;

public class Cab {
    private final UUID cabUUID;

    private final String brand;

    private final String model;

    private final int mileage;

    private final int manufacturingYear;

    private final boolean papersVerified;

    private final Coordinates coordinates;

    private Cab(Builder builder) {
        this.cabUUID = builder.cabUUID;
        this.brand = builder.brand;
        this.model = builder.model;
        this.mileage = builder.mileage;
        this.manufacturingYear = builder.manufacturingYear;
        this.papersVerified = builder.papersVerified;
        this.coordinates = builder.coordinates;
    }

    public UUID getCabUUID() {
        return cabUUID;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public boolean isPapersVerified() {
        return papersVerified;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "cabUUID=" + cabUUID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                ", manufacturingYear=" + manufacturingYear +
                ", papersVerified=" + papersVerified +
                ", coordinates=" + coordinates +
                '}';
    }

    public static class Builder {
        private UUID        cabUUID;
        private String      brand;
        private String      model;
        private int         mileage;
        private int         manufacturingYear;
        private boolean     papersVerified;
        private Coordinates coordinates;

        public Builder() { }

        public Builder from(Cab cab) {
            this.cabUUID = cab.getCabUUID();
            this.brand = cab.getBrand();
            this.model = cab.getModel();
            this.mileage = cab.getMileage();
            this.manufacturingYear = cab.getManufacturingYear();
            this.papersVerified = cab.isPapersVerified();
            this.coordinates = cab.getCoordinates();

            return this;
        }

        public Builder cabUUID(UUID cabUUID) {
            this.cabUUID = cabUUID;
            return this;
        }

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder mileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

        public Builder manufacturingYear(int manufacturingYear) {
            this.manufacturingYear = manufacturingYear;
            return this;
        }

        public Builder papersVerified(boolean papersVerified) {
            this.papersVerified = papersVerified;
            return this;
        }

        public Builder coordinates(Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public Cab build() {
            return new Cab(this);
        }
    }
}
