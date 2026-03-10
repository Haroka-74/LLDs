package factories;

public class VehicleFactory {
    public static Vehicle create(String licensePlate, VehicleType type) {
        return type.create(licensePlate);
    }
}