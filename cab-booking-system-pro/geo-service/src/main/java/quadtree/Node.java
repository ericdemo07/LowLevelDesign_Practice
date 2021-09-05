package quadtree;

import java.util.ArrayList;
import java.util.List;

import models.Location;

public class Node {
    List<Location> locationList;

    double latitudeCentroid, longitudeCentroid;

    Node parent;
    Node topLeft, topRight, bottomLeft, bottomRight;

    public Node(double latitudeCentroid, double longitudeCentroid) {
        locationList = new ArrayList<>();

        this.latitudeCentroid = latitudeCentroid;
        this.longitudeCentroid = longitudeCentroid;
    }

    public Node(Location location) {
        locationList = new ArrayList<>();
        locationList.add(location);
    }

    public boolean isLeafNode() {
        return topLeft == null && topRight == null && bottomLeft == null && bottomRight == null;
    }

    @Override
    public String toString() {
        return locationList.size() + "  " + locationList.toString();
    }
}
