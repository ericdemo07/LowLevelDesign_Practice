package com.doom.geoservice.models;

public class CoordinateModel {
    private int x;
    private int y;

    public CoordinateModel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
