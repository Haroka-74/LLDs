package factories;

import models.Size;

public class Car extends Vehicle {

    public Car(String licensePlate) {
        super(licensePlate);
    }

    @Override
    public Size getSize() {
        return Size.M;
    }
}