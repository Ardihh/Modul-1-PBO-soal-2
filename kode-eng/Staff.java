public class Staff extends Employee {
    public Staff(String name, String employeeId, int tripDuration, double transportCost, boolean outOfTown) {
        super(name, employeeId, "Staff", tripDuration, transportCost, outOfTown);
    }

    @Override
    public double calculateDailyAllowance() {
        return 200000 * getTripDuration();
    }

    @Override
    public double calculateLodging() {
        return Math.max(getTripDuration() - 1, 0) * 400000;
    }
}
