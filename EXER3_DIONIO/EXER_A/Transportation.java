public class Transportation {
    protected String name;
    protected int capacity;

    public Transportation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void move() {
        System.out.println(name + " moves with capacity " + capacity + ".");
    }
}