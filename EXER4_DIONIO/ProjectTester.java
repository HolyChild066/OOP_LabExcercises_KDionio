// ProjectTester class
public class ProjectTester {
    public static void main(String[] args) {
        System.out.println("=== POLYMORPHISM DEMONSTRATION ===\n");

        // 1. Runtime Polymorphism (Method Overriding)
        System.out.println("1. RUNTIME POLYMORPHISM:");
        System.out.println("------------------------");
        
        Person[] people = {
            new Person("John Doe", 45),
            new Patient("Alice Smith", 30, "P001"),
            new Dentist("Emily Johnson", 40, "D001", "Orthodontics")
        };

        // Same method call, different behavior
        for (Person person : people) {
            person.displayInfo(); // Polymorphic call
            System.out.println("Role: " + person.getRole());
            System.out.println();
        }

        // 2. Compile-time Polymorphism (Method Overloading)
        System.out.println("2. COMPILE-TIME POLYMORPHISM:");
        System.out.println("-----------------------------");
        
        // Constructor overloading
        Person p1 = new Person("Bob Wilson", 35);
        Person p2 = new Person("Jane Brown"); // Different constructor
        p1.displayInfo();
        p2.displayInfo();
        System.out.println();

        // Method overloading
        Appointment apt = new Appointment("P002", "Mike Davis", DentalService.CLEANING, "10:00 AM");
        System.out.println("Original: " + apt);
        
        apt.updateAppointment("2:00 PM");           // Different parameter
        apt.updateAppointment(DentalService.FILLING); // Different parameter type
        System.out.println();

    }
}