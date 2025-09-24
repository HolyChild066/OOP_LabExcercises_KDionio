enum DentalService {
    CLEANING("Dental Cleaning"),
    FILLING("Tooth Filling"), 
    EXTRACTION("Tooth Extraction"),
    CHECKUP("Regular Checkup");

    private final String serviceName;

    DentalService(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    @Override
    public String toString() {
        return serviceName;
    }
}