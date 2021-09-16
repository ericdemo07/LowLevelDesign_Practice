package com.doom.geoservice.quadtree;

import com.doom.geoservice.models.Location;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.doom.geoservice.utils.Constants.NODE_BREAKING_THRESHOLD;


public final class QuadTreeService {

    private static volatile QuadTreeService instance;

    private Node locationTree;

    private LinkedList<Node> doublyLinkedList;

    public void buildTree(List<Location> locationList) {
        for (Location location : locationList) {
            insert(location);
        }

        buildLeavesConnectedLinkedList();
    }

    public void traverse() {
        traverse(locationTree);
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

    public void printLinkedList() {
        System.out.println(doublyLinkedList);
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
                node.locationList.clear();

                double[] centroid = findCentroid(locationList);
                for (Location loc : locationList) {
                    node = insert(node, loc, centroid);
                }
            }
        }
        else {
            double[] centroid = new double[]{node.latitudeCentroid, node.longitudeCentroid};
            node = insert(node, location, centroid);
        }
        return node;
    }

    private Node insert(Node node, Location location, double[] centroid) {
        if (location.getLatitude() > centroid[0] && location.getLongitude() < centroid[1]) {
            node.topLeft = insert(node.topLeft, location);
        }
        else if (location.getLatitude() > centroid[0] && location.getLongitude() > centroid[1]) {
            node.topRight = insert(node.topRight, location);
        }
        else if (location.getLatitude() < centroid[0] && location.getLongitude() < centroid[1]) {
            node.bottomLeft = insert(node.bottomLeft, location);
        }
        else {
            node.bottomRight = insert(node.bottomRight, location);
        }

        return node;
    }

    private void buildLeavesConnectedLinkedList() {
        //?: how to traverse in this list
        doublyLinkedList = new LinkedList<>();
        buildLeavesConnectedLinkedList(locationTree);
    }

    private void buildLeavesConnectedLinkedList(Node node) {
        if (node.isLeafNode()) {
            doublyLinkedList.add(node);
            return;
        }
        buildLeavesConnectedLinkedList(node.topLeft);
        buildLeavesConnectedLinkedList(node.topRight);
        buildLeavesConnectedLinkedList(node.bottomLeft);
        buildLeavesConnectedLinkedList(node.bottomRight);
    }

    private double[] findCentroid(List<Location> locationList) {

        double latitudeSum = 0;
        double longitudeSum = 0;

        for (Location location : locationList) {
            latitudeSum += location.getLatitude();
            longitudeSum += location.getLongitude();
        }

        return new double[]{latitudeSum / locationList.size(), longitudeSum / locationList.size()};
    }

    public static synchronized QuadTreeService getInstance() {
        if (instance == null) {
            synchronized (QuadTreeService.class) {
                if (instance == null) {
                    instance = new QuadTreeService();
                }
            }
        }
        return instance;
    }
}
