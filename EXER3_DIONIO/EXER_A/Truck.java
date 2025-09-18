class Truck extends LandTransport {
    private int loadCapacity; // in tons

    public Truck(int loadCapacity) {
        super("Truck", 3, 120, "Diesel");
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() { return loadCapacity; }

    @Override
    public void move() {
        System.out.println(getName() + " carries " + loadCapacity +
                " tons at " + getSpeed() + " km/h.");
    }
}