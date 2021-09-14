package com.parkinglot.storage;

import com.parkinglot.models.CarModel;

import java.util.PriorityQueue;

public class ParkingDataStore {

    private static volatile ParkingDataStore instance;

    private final CarModel[] parkingSlots;

    private final PriorityQueue<Integer> pq;

    private ParkingDataStore(int parkingCapacity) {
        this.parkingSlots = new CarModel[parkingCapacity];
        this.pq = new PriorityQueue<>();

        for (int i = 0; i < parkingCapacity; i++) {
            this.pq.add(i);
        }
    }

    public static synchronized void initializeInstance(int n) {
        if (instance == null) {
            synchronized (ParkingDataStore.class) {
                if (instance == null) {
                    instance = new ParkingDataStore(n);
                }
            }
        }
    }

    public static synchronized ParkingDataStore getInstance() {
        return instance;
    }

    public int addCar(CarModel car) {
        if (pq.isEmpty()) {
            return -1;
        }

        int parkingSlot = pq.poll();

        parkingSlots[parkingSlot] = car;

        return parkingSlot;
    }

    public boolean removeCar(int parkingSlot) {
        parkingSlots[parkingSlot] = null;
        return pq.add(parkingSlot);
    }

    public boolean parkingFull() {
        return pq.isEmpty();
    }

    public int getParkingLotSize() {
        return parkingSlots.length;
    }

    private static final String[] header = {"Slot No.", "Registration No", "Colour"};

    public void status() {
        for (String str : header) {
            System.out.print(str);
            System.out.print("\t");
        }

        for (int i = 0; i < parkingSlots.length; i++) {
            if (parkingSlots[i] == null) {
                continue;
            }

            System.out.print("\n");
            System.out.print(i + 1);
            System.out.print("\t");
            System.out.print(parkingSlots[i].getRegistrationNumber());
            System.out.print("\t");
            System.out.print(parkingSlots[i].getColor());
            System.out.print("\t");
        }
    }

    public String getRegistrationNumberOfCarsOfGivenColor(String color) {
        StringBuilder builder = new StringBuilder();

        for (CarModel model : parkingSlots) {
            if (color.equals(model.getColor())) {
                builder.append(model.getRegistrationNumber()).append(", ");
            }
        }

        if (builder.length() != 0) {
            builder.delete(builder.length() - 2, builder.length() - 1);
        }

        return builder.toString();
    }

    public int getSlotNumberWithRegistrationNumber(String registrationNumber) {

        for (int i = 0; i < parkingSlots.length; i++) {
            if (registrationNumber.equals(parkingSlots[i].getRegistrationNumber())) {
                return i + 1;
            }
        }

        return -1;
    }

    public String getSlotNumberOfCarsWithGivenColor(String color) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < parkingSlots.length; i++) {
            if (color.equals(parkingSlots[i].getColor())) {
                builder.append(i + 1).append(", ");
            }
        }

        if (builder.length() != 0) {
            builder.delete(builder.length() - 2, builder.length() - 1);
        }

        return builder.toString();
    }
}
