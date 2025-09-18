public class SpaceShuttle extends AirTransport {
    private boolean reusable;

    public SpaceShuttle(String name, int capacity, double maxAltitude, boolean reusable) {
        super(name, capacity, maxAltitude);
        this.reusable = reusable;
    }

    public void type() {
        System.out.println("This is a Space Shuttle. Reusable: " + reusable);
    }
}