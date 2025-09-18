public class AirTransport extends Transportation {
    protected double maxAltitude;

    public AirTransport(String name, int capacity, double maxAltitude) {
        super(name, capacity);
        this.maxAltitude = maxAltitude;
    }

    public void fly() {
        System.out.println(name + " flies at max altitude of " + maxAltitude + " meters.");
    }
}