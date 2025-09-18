public class Kariton extends LandTransport {
    private boolean hasAnimal;

    public Kariton(String name, int capacity, int wheels, boolean hasAnimal) {
        super(name, capacity, wheels);
        this.hasAnimal = hasAnimal;
    }

    public void type() {
        System.out.println("This is a Kariton. Pulled by animal: " + hasAnimal);
    }
}