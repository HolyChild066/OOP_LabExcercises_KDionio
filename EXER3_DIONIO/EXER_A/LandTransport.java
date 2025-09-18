public class LandTransport extends Transportation {
    protected int wheels;

    public LandTransport(String name, int capacity, int wheels) {
        super(name, capacity);
        this.wheels = wheels;
    }

    public void drive() {
        System.out.println(name + " drives on " + wheels + " wheels.");
    }
}