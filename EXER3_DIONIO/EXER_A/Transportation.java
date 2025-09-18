public class Transportation {
    private String name;
    private int capacity;
    private int speed;
    private String fuelType;

    // Constructor
    public Transportation(String name, int capacity, int speed, String fuelType) {
        this.name = name;
        this.capacity = capacity;
        this.speed = speed;
        this.fuelType = fuelType;
    }

    // Encapsulation: Getters and Setters
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public int getSpeed() { return speed; }
    public String getFuelType() { return fuelType; }

    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setSpeed(int speed) { this.speed = speed; }
    public void setFuelType(String fuelType) { this.fuelType = fuelType; }

    // Common method
    public void move() {
        System.out.println(name + " is moving at " + speed + " km/h using " + fuelType + ".");
    }
}