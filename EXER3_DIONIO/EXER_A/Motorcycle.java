public class Motorcycle extends LandTransport {
    private int cc;

    public Motorcycle(String name, int capacity, int wheels, int cc) {
        super(name, capacity, wheels);
        this.cc = cc;
    }

    public void type() {
        System.out.println("This is a Motorcycle with " + cc + "cc engine.");
    }
}