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
        int night = getTripDuration() - 1;
        return (night > 0 ? night : 0) * 400000;
    }
}
