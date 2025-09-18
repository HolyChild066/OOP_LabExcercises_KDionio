public class Truck extends LandTransport {
    private double maxLoad;

    public Truck(String name, int capacity, int wheels, double maxLoad) {
        super(name, capacity, wheels);
        this.maxLoad = maxLoad;
    }

    public void type() {
        System.out.println("This is a Truck with max load " + maxLoad + " tons.");
    }
}