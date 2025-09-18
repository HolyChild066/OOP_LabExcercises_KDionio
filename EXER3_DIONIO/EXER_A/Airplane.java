public class Airplane extends AirTransport {
    private int engines;

    public Airplane(String name, int capacity, double maxAltitude, int engines) {
        super(name, capacity, maxAltitude);
        this.engines = engines;
    }

    public void type() {
        System.out.println("This is an Airplane with " + engines + " engines.");
    }
}