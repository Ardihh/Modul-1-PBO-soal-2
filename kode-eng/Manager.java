public class Manager extends Employee {
    public Manager(String name, String employeeId, int tripDuration, double transportCost, boolean outOfTown) {
        super(name, employeeId, "Manager", tripDuration, transportCost, outOfTown);
    }

    @Override
    public double calculateDailyAllowance() {
        return 350000 * getTripDuration();
    }

    @Override
    public double calculateLodging() {
        int night = getTripDuration() - 1;
        return (night > 0 ? night : 0) * 800000;
    }
}
