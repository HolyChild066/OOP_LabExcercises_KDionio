public class WaterTransport extends Transportation {
    protected double maxDepth;

    public WaterTransport(String name, int capacity, double maxDepth) {
        super(name, capacity);
        this.maxDepth = maxDepth;
    }

    public void sail() {
        System.out.println(name + " sails at max depth " + maxDepth + " meters.");
    }
}