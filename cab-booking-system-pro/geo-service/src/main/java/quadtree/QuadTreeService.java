package quadtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import models.Location;

public class QuadTreeService {

    private Node locationTree;

    private static final int NODE_BREAKING_THRESHOLD = 10;

    public static void main(String[] args) {
        QuadTreeService quadTreeService = new QuadTreeService();
        quadTreeService.process();
    }

    private void process() {
        buildTree(dummyLocations());
        traverse(locationTree);
    }

    public void buildTree(List<Location> locationList) {
        intializeTree();

        for (Location location : locationList) {
            insert(location);
        }
    }

    private void intializeTree() {
        locationTree = new Node(0, 0);
    }

    private void traverse(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node);
        traverse(node.topLeft);
        traverse(node.topRight);
        traverse(node.bottomLeft);
        traverse(node.bottomRight);
    }

    private void insert(Location location) {
        locationTree = insert(locationTree, location);
    }

    private Node insert(Node node, Location location) {
        if (node == null) {
            return new Node(location);
        }

        if (node.isLeafNode()) {
            if (node.locationList.size() < NODE_BREAKING_THRESHOLD) {
                node.locationList.add(location);
            }
            else {
                List<Location> locationList = new ArrayList<>(node.locationList);

                double[] centroid = findCentroid(locationList);
                node.locationList.clear();
                for (Location location1 : locationList) {
                    if (location1.getLatitude() > centroid[0] && location1.getLongitude() < centroid[1]) {
                        node.topLeft = insert(node.topLeft, location1);
                    }
                    else if (location1.getLatitude() > centroid[0] && location1.getLongitude() > centroid[1]) {
                        node.topRight = insert(node.topRight, location1);
                    }
                    else if (location1.getLatitude() < centroid[0] && location1.getLongitude() < centroid[1]) {
                        node.bottomLeft = insert(node.bottomLeft, location1);
                    }
                    else {
                        node.bottomRight = insert(node.bottomRight, location1);
                    }
                }
            }
        }
        else {
            if (location.getLatitude() > node.latitudeCentroid && location.getLongitude() < node.longitudeCentroid) {
                node.topLeft = insert(node.topLeft, location);
            }
            else if (location.getLatitude() > node.latitudeCentroid && location.getLongitude() > node.longitudeCentroid) {
                node.topRight = insert(node.topRight, location);
            }
            else if (location.getLatitude() < node.latitudeCentroid && location.getLongitude() < node.longitudeCentroid) {
                node.bottomLeft = insert(node.bottomLeft, location);
            }
            else {
                node.bottomRight = insert(node.bottomRight, location);
            }
        }
        return node;
    }


    private double[] findCentroid(List<Location> locationList) {

        double smallestLatitude = Double.MAX_VALUE;
        double biggestLatitude = Double.MIN_NORMAL;

        double smallestLongitude = Double.MAX_VALUE;
        double biggestLongitude = Double.MIN_NORMAL;

        for (Location location : locationList) {
            smallestLatitude = Math.min(smallestLatitude, location.getLatitude());
            biggestLatitude = Math.max(biggestLatitude, location.getLatitude());

            smallestLongitude = Math.min(smallestLongitude, location.getLongitude());
            biggestLongitude = Math.max(biggestLongitude, location.getLongitude());
        }

        double latitudeCentroid = (smallestLatitude + biggestLatitude) / 2;
        double longitudeCentroid = (smallestLongitude + biggestLongitude) / 2;

        return new double[]{latitudeCentroid, longitudeCentroid};
    }


    private List<Location> dummyLocations() {
        List<Location> list = new ArrayList<>();

        double latStart = 1.00, lngStart = 3.00;
        Random random = new Random();
        for (int i = 0; i < 57; i++) {
            int x = random.nextInt(16);
            int y = random.nextInt(16);
            if (x % 2 == 0 && y % 2 == 0) {
                list.add(dummyLocation(latStart + random.nextInt(16), lngStart + random.nextInt(18)));
            }
            else if (x % 2 == 0) {
                list.add(dummyLocation(latStart - random.nextInt(16), lngStart + random.nextInt(18)));
            }
            else if (y % 2 == 0) {
                list.add(dummyLocation(latStart + random.nextInt(16), lngStart - random.nextInt(18)));
            }
            else {
                list.add(dummyLocation(latStart - random.nextInt(16), lngStart - random.nextInt(18)));
            }
        }

        return list;
    }

    private Location dummyLocation(double latitude, double longitude) {
        Location location = new Location();

        location.setLocationUUID(UUID.randomUUID());
        location.setLatitude(latitude);
        location.setLongitude(longitude);

        return location;
    }
}
