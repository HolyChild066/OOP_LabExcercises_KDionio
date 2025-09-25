class Patient extends Person {
    private final String patientId;

    public Patient(String name, int age, String patientId) {
        super(name, age);
        this.patientId = patientId;
    }

    // Method overriding (Runtime Polymorphism)
    @Override
    public void displayInfo() {
        System.out.println("Patient: " + name + ", Age: " + age + ", ID: " + patientId);
    }

    @Override
    public String getRole() {
        return "Patient";
    }

    public String getPatientId() {
        return patientId;
    }
}


