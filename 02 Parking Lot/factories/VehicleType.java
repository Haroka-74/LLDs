package factories;

public enum VehicleType {
    MOTORCYCLE {
        @Override
        public Vehicle create(String plate) { return new Motorcycle(plate); }
    },
    CAR {
        @Override
        public Vehicle create(String plate) { return new Car(plate); }
    },
    TRUCK {
        @Override
        public Vehicle create(String plate) { return new Truck(plate); }
    };

    public abstract Vehicle create(String plate);
}