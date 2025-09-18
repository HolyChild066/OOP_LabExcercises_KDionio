public class Boat extends WaterTransport {
    private String type; // fishing, yacht, etc.

    public Boat(String type) {
        super("Boat", 20, 50, "Diesel");
        this.type = type;
    }

    public String getType() { return type; }

    @Override
    public void move() {
        System.out.println(type + " " + getName() + " is sailing with " +
                getCapacity() + " people at " + getSpeed() + " km/h.");
    }
}