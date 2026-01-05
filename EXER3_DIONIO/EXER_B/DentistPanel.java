class Dentist extends Person {
    private String dentistId;
    private String specialization;

    public Dentist(String name, int age, String dentistId, String specialization) {
        super(name, age);
        this.dentistId = dentistId;
        this.specialization = specialization;
    }

    // Method overriding (Runtime Polymorphism)
    @Override
    public void displayInfo() {
        System.out.println("Dentist: Dr. " + name + ", Age: " + age + 
                         ", ID: " + dentistId + ", Specialty: " + specialization);
    }

    @Override
    public String getRole() {
        return "Dentist";
    }

    public String getDentistId() {
        return dentistId;
    }

    public String getSpecialization() {
        return specialization;
    }
}