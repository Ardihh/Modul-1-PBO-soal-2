public class Employee {
    // Encapsulation: all attributes are private, accessed through getters/setters
    private String name;
    private String employeeId;
    private String position;
    private int tripDuration;
    private double transportCost;
    private boolean outOfTown;

    public Employee(String name, String employeeId, String position, int tripDuration,
                    double transportCost, boolean outOfTown) {
        this.name = name;
        this.employeeId = employeeId;
        this.position = position;
        this.tripDuration = tripDuration;
        this.transportCost = transportCost;
        this.outOfTown = outOfTown;
    }

    // ===== Getters & Setters =====
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getTripDuration() {
        return tripDuration;
    }

    public void setTripDuration(int tripDuration) {
        this.tripDuration = tripDuration;
    }

    public double getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(double transportCost) {
        this.transportCost = transportCost;
    }

    public boolean isOutOfTown() {
        return outOfTown;
    }

    public void setOutOfTown(boolean outOfTown) {
        this.outOfTown = outOfTown;
    }

    // ===== Overloading calculateTransportCost =====

    // Standard transport cost (ticket cost)
    public double calculateTransportCost() {
        return transportCost;
    }

    // Transport cost + car rental (used only by Director)
    public double calculateTransportCost(double carRentalCost) {
        return transportCost + carRentalCost;
    }

    // ===== Methods overridden by subclasses (Polymorphism) =====

    // Daily allowance for the whole trip. Default 0, overridden by subclasses
    public double calculateDailyAllowance() {
        return 0;
    }

    // Lodging cost (number of nights = trip duration - 1). Default 0, overridden by subclasses
    public double calculateLodging() {
        return 0;
    }

    // Label of the transport line in the report. Default "Transport Cost", overridden by Director
    public String getTransportLabel() {
        return "Transport Cost";
    }

    // Total = daily allowance + transport + lodging (only if out of town)
    public double calculateTotalCost(boolean outOfTown) {
        double total = calculateDailyAllowance() + calculateTransportCost();
        if (outOfTown) {
            total += calculateLodging();
        }
        return total;
    }
}
