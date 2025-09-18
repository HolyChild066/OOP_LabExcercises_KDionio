public class SUV extends LandTransport {
    private boolean fourWheelDrive;

    public SUV(String name, int capacity, int wheels, boolean fourWheelDrive) {
        super(name, capacity, wheels);
        this.fourWheelDrive = fourWheelDrive;
    }

    public void type() {
        System.out.println("This is an SUV. 4WD: " + fourWheelDrive);
    }
}