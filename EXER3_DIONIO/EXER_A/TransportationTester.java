public public class TransportationTester {
    public static void main(String[] args) {
        // Air
        Airplane plane = new Airplane("Philippine Airlines");
        Helicopter heli = new Helicopter(4);

        // Land
        Truck truck = new Truck(10);
        Motorcycle moto = new Motorcycle(650);

        // Water
        Boat boat = new Boat("Fishing");
        Submarine sub = new Submarine(500);

        // Test Outputs
        plane.move();
        heli.move();
        truck.move();
        moto.move();
        boat.move();
        sub.move();
    }
}