package models;

import constants.Colors;
import factories.Vehicle;

public class ParkingSpot {
    private int id;
    private Size spotSize;
    private Vehicle vehicle;

    public ParkingSpot(int id, Size spotSize) {
        this.id = id;
        this.spotSize = spotSize;
        vehicle = null;
    }

    public int getId() {
        return id;
    }

    public boolean fits(Vehicle vehicle) {
        return this.vehicle == null && spotSize == vehicle.getSize();
    }

    public boolean isOccupied(Vehicle vehicle) {
        return this.vehicle != null && this.vehicle.equals(vehicle);
    }

    public void assign(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void release() {
        this.vehicle = null;
    }

    @Override
    public String toString() {
        String color = vehicle != null ? Colors.RED : Colors.GREEN;
        return color + "[" + spotSize + "] SPOT " + String.format("%02d", id) + Colors.RESET;
    }
}