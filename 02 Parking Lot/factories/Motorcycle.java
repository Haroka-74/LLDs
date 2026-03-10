package factories;

import models.Size;

public class Motorcycle extends Vehicle {

    public Motorcycle(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public Size getSize() {
        return Size.S;
    }
}