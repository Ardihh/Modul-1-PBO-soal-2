import java.util.ArrayList;

public class Company {
    private String companyName;
    private ArrayList<Employee> employeeList;

    public Company(String companyName) {
        this.companyName = companyName;
        this.employeeList = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    // Format rupiah value: 6000000 -> "Rp 6.000.000"
    private String formatRupiah(double value) {
        long rounded = Math.round(value);
        String digits = String.valueOf(Math.abs(rounded));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            if (i > 0 && (digits.length() - i) % 3 == 0) {
                result.append('.');
            }
            result.append(digits.charAt(i));
        }
        return (rounded < 0 ? "-Rp " : "Rp ") + result;
    }

    // Print one report line: label padded to at least 15 characters so the colons line up
    private void printLine(String label, String content) {
        System.out.printf("%-15s : %s%n", label, content);
    }

    // Loop and print the report of every employee, then the grand total
    public void calculateAllCosts() {
        String topLine = "=======================================";
        String separator = "---------------------------------------";
        double grandTotal = 0;

        System.out.println(topLine);
        System.out.println("BUSINESS TRIP REIMBURSEMENT REPORT");
        System.out.println(topLine);

        for (int i = 0; i < employeeList.size(); i++) {
            Employee e = employeeList.get(i);
            boolean outOfTown = e.isOutOfTown();
            double total = e.calculateTotalCost(outOfTown);
            grandTotal += total;

            printLine("Employee Name", e.getName());
            printLine("ID", e.getEmployeeId());
            printLine("Position", e.getPosition());
            printLine("Trip Duration", e.getTripDuration() + " days");
            printLine("Destination", outOfTown ? "Out of Town" : "In Town");
            printLine("Daily Allowance", formatRupiah(e.calculateDailyAllowance()));

            if (outOfTown) {
                printLine("Lodging", formatRupiah(e.calculateLodging()));
            } else {
                printLine("Lodging", "Rp 0 (no overnight stay)");
            }

            // Label and value of the transport line come from each subclass's own methods
            printLine(e.getTransportLabel(), formatRupiah(e.calculateTransportCost()));

            printLine("Total Reimbursement", formatRupiah(total));

            if (i < employeeList.size() - 1) {
                System.out.println(separator);
            }
        }
        System.out.println(topLine);
        printLine("GRAND TOTAL", formatRupiah(grandTotal));
        System.out.println(topLine);
    }
}
