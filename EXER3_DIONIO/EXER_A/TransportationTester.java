public class TransportationTester {
    public static void main(String[] args) {
        Helicopter helicopter = new Helicopter("Rescue Helicopter", 5, 3000, 2);
        Airplane airplane = new Airplane("Boeing 747", 416, 13000, 4);
        SpaceShuttle spaceShuttle = new SpaceShuttle("Discovery", 7, 400000, true);

        Truck truck = new Truck("Cargo Truck", 2, 6, 20);
        SUV suv = new SUV("Family SUV", 7, 4, true);
        Tricycle tricycle = new Tricycle("Passenger Tricycle", 3, 3, false);
        Motorcycle motorcycle = new Motorcycle("Sport Bike", 2, 2, 600);
        Kariton kariton = new Kariton("Farmer's Kariton", 1, 2, true);

        Boat boat = new Boat("Fishing Boat", 10, 50, "Fishing");
        Submarine submarine = new Submarine("Navy Submarine", 50, 500, true);

        helicopter.type(); helicopter.fly(); helicopter.move();
        airplane.type(); airplane.fly(); airplane.move();
        spaceShuttle.type(); spaceShuttle.fly(); spaceShuttle.move();

        truck.type(); truck.drive(); truck.move();
        suv.type(); suv.drive(); suv.move();
        tricycle.type(); tricycle.drive(); tricycle.move();
        motorcycle.type(); motorcycle.drive(); motorcycle.move();
        kariton.type(); kariton.drive(); kariton.move();

        boat.type(); boat.sail(); boat.move();
        submarine.type(); submarine.sail(); submarine.move();
    }
}