public class Director extends Employee {
    private double carRentalCost;

    public Director(String name, String employeeId, int tripDuration, double transportCost,
                    double carRentalCost, boolean outOfTown) {
        super(name, employeeId, "Director", tripDuration, transportCost, outOfTown);
        this.carRentalCost = carRentalCost;
    }

    public double getCarRentalCost() {
        return carRentalCost;
    }

    public void setCarRentalCost(double carRentalCost) {
        this.carRentalCost = carRentalCost;
    }

    // Director's transport = ticket + car rental (uses the overloaded method in the superclass)
    @Override
    public double calculateTransportCost() {
        return calculateTransportCost(carRentalCost);
    }

    @Override
    public String getTransportLabel() {
        return "Transport + Car Rental";
    }

    @Override
    public double calculateDailyAllowance() {
        return 500000 * getTripDuration();
    }

    @Override
    public double calculateLodging() {
        int night = getTripDuration() - 1;
        return (night > 0 ? night : 0) * 1200000;
    }
}
