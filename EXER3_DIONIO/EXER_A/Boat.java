public class Boat extends WaterTransport {
    private String boatType;

    public Boat(String name, int capacity, double maxDepth, String boatType) {
        super(name, capacity, maxDepth);
        this.boatType = boatType;
    }

    public void type() {
        System.out.println("This is a " + boatType + " Boat.");
    }
}