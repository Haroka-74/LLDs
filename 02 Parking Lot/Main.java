import models.ParkingLot;
import factories.VehicleType;
import factories.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        ParkingLot lot = ParkingLot.get();

        System.out.println(lot);

        var v1 = VehicleFactory.create("MOT-01", VehicleType.MOTORCYCLE);
        var v2 = VehicleFactory.create("CAR-01", VehicleType.CAR);
        var v3 = VehicleFactory.create("CAR-02", VehicleType.CAR);
        var v4 = VehicleFactory.create("TRU-01", VehicleType.TRUCK);

        var t1 = lot.park(v1);
        var t2 = lot.park(v2);
        var t3 = lot.park(v3);
        var t4 = lot.park(v4);

        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);

        System.out.println(lot);

        var f1 = lot.unpark(t1);
        var f2 = lot.unpark(t3);

        System.out.println("> Unpark MOT-01 and CAR-02");

        System.out.printf("\t > Fee for MOT-01: $%.2f%n", f1.calculate());
        System.out.printf("\t > Fee for CAR-02: $%.2f%n", f2.calculate());

        System.out.println(lot);

        for(int i = 1; i <= 10; i++) {
            lot.park(VehicleFactory.create("MOT-" + i, VehicleType.MOTORCYCLE));
        }

        System.out.println(lot);
    }
}