public class Helicopter extends AirTransport {
    private int rotorBlades;

    public Helicopter(int rotorBlades) {
        super("Helicopter", 5, 250, "Aviation Fuel");
        this.rotorBlades = rotorBlades;
    }

    public int getRotorBlades() { return rotorBlades; }

    @Override
    public void move() {
        System.out.println(getName() + " with " + rotorBlades +
                " rotor blades is hovering at " + getSpeed() + " km/h.");
    }
}