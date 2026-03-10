package factories;

import models.Size;

public class Truck extends Vehicle {

    public Truck(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public Size getSize() {
        return Size.L;
    }
}