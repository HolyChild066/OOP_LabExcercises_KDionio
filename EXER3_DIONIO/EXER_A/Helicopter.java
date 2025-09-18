public class Helicopter extends AirTransport {
    private int rotors;

    public Helicopter(String name, int capacity, double maxAltitude, int rotors) {
        super(name, capacity, maxAltitude);
        this.rotors = rotors;
    }

    public void type() {
        System.out.println("This is a Helicopter with " + rotors + " rotors.");
    }
}