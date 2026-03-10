package models;

import java.util.UUID;
import factories.Vehicle;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Ticket {
    private String id;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalTime entryTime;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalTime.now();
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return String.format(
            "Ticket(id: %s, plate: %s, size: %s, spot: #%02d, entry: %s)",
            id,
            vehicle.getLicensePlate(),
            vehicle.getSize(),
            spot.getId(),
            entryTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        );
    }
}