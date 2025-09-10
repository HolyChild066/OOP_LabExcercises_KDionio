public class CarTester{
    public static void main(String [] args){
        Car car1 = new Car("Toyota", "Corolla", "139-169 hp", "White", "5 Seaters", "CVT 6-Speed Manual");
        Car car2 = new Car("Honda", "Civic", "158-180 hp", "Black", "5 Seaters", "CVT 6-Speed Manual");
        Car car3 = new Car("Ford", "F-150", "290-450 hp", "Silver", "3-6 Seaters", "10 Speed Automatic");
        Car car4 = new Car("Tesla", "Model-3", "283-450 hp", "White", "5 Seaters", "Single Speed Automatic(EV)");
        Car car5 = new Car("Hyundai", "Elantra", "147-276", "Gray", "5 Seaters", "CVT 6-Speed Manual,7-Speed DCT");
        Car car6 = new Car("Toyota", "Camry", "203-301 hp", "Black", "5 Seaters", "8 Speed Automatic");
        Car car7 = new Car("Honda", "Accord", "192-204 hp", "Gray", "5 Seaters", "CVT, e-CVT(Hybrid)");
        Car car8 = new Car("Chevrolet", "Silverado-1500", "310-420 hp", "White", "3-6 Seaters", "8 Speed or 10 Speed Automatic");
        Car car9 = new Car("Nissan", "Altima", "188-248 hp", "White", "5 Seaters", "CVT");
        Car car10 = new Car("Kia", "Sportage", "187-261 hp", "White", "5 Seaters", "8 Speed Automatic,6 Speed (Hybrid)");

        System.out.println(car1.getDetails());
        System.out.println(car2.getDetails());
        System.out.println(car3.getDetails());
        System.out.println(car4.getDetails());
        System.out.println(car5.getDetails());
        System.out.println(car6.getDetails());
        System.out.println(car7.getDetails());
        System.out.println(car8.getDetails());
        System.out.println(car91.getDetails());
        System.out.println(car10.getDetails());
    }
}