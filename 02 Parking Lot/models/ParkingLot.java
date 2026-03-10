package models;

import java.util.List;
import factories.Vehicle;
import java.util.ArrayList;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingSpot> spots = new ArrayList<>();

    private ParkingLot() {
        for(int i = 1; i <= 10; i++) spots.add(new ParkingSpot(i, Size.S));
        for(int i = 11; i <= 40; i++) spots.add(new ParkingSpot(i, Size.M));
        for(int i = 41; i <= 50; i++) spots.add(new ParkingSpot(i, Size.L));
    }

    public static ParkingLot get() {
        if(instance == null)
            instance = new ParkingLot();
        return instance;
    }

    public Ticket park(Vehicle vehicle) {
        for(ParkingSpot spot : spots) {
            if(spot.fits(vehicle)) {
                spot.assign(vehicle);
                return new Ticket(vehicle, spot);
            }
        }
        return null;
    }

    public Fee unpark(Ticket ticket) {
        var spot = ticket.getSpot();

        if(!spot.isOccupied(ticket.getVehicle()))
            return null;

        spot.release();
        return new Fee(ticket);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 50; i++) {
            if((i + 1) % 5 == 0) {
                sb.append(spots.get(i)).append("\n");
            } else {
                sb.append(spots.get(i)).append(" | ");
            }
        }
        return sb.toString();
    }
}