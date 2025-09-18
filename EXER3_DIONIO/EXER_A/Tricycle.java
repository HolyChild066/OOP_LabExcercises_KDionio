public class Tricycle extends LandTransport {
    private boolean hasSidecar;

    public Tricycle(String name, int capacity, int wheels, boolean hasSidecar) {
        super(name, capacity, wheels);
        this.hasSidecar = hasSidecar;
    }

    public void type() {
        System.out.println("This is a Tricycle. Has sidecar: " + hasSidecar);
    }
}