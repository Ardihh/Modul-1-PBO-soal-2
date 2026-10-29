public class Main {
    public static void main(String[] args) {
        Company company = new Company("PT Mitra Konsultan Prima");

        Employee employee1 = new Director("Bayu", "DIR01", 4, 3000000, 1500000, true);
        Employee employee2 = new Manager("Maya", "MGR01", 3, 1800000, true);
        Employee employee3 = new Staff("Fajar", "STF01", 5, 1200000, true);
        Employee employee4 = new Staff("Nadia", "STF02", 2, 150000, false);

        company.addEmployee(employee1);
        company.addEmployee(employee2);
        company.addEmployee(employee3);
        company.addEmployee(employee4);

        company.calculateAllCosts();
    }
}
