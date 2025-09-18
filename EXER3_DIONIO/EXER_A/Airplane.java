public class Airplane extends AirTransport {
    private String airline;

    public Airplane(String airline) {
        super("Airplane", 180, 900, "Jet Fuel");
        this.airline = airline;
    }

    public String getAirline() { return airline; }

    @Override
    public void move() {
        System.out.println(getName() + " of " + airline + " is flying with " +
                getCapacity() + " passengers at " + getSpeed() + " km/h.");
    }
}