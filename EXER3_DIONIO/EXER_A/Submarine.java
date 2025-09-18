public class Submarine extends WaterTransport {
    private boolean nuclearPowered;

    public Submarine(String name, int capacity, double maxDepth, boolean nuclearPowered) {
        super(name, capacity, maxDepth);
        this.nuclearPowered = nuclearPowered;
    }

    public void type() {
        System.out.println("This is a Submarine. Nuclear powered: " + nuclearPowered);
    }
}