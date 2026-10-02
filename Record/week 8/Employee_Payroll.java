import java.util.Scanner;

// Base interface for salary operations
interface Salary {

    double calculateSalary();

    void displaySalary();
}

// Extended interface
interface EmployeeSalary extends Salary {

    String getEmployeeId();
}

// Regular Employee class
class RegularEmployee implements EmployeeSalary {

    private String employeeId;
    private double basicPay;
    private double hra;
    private double ta;

    // Constructor
    RegularEmployee(String employeeId) {
        this.employeeId = employeeId;
        this.basicPay = 25000;
        this.hra = 15000;
        this.ta = 5000;
    }

    @Override
    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public double calculateSalary() {
        return basicPay + hra + ta;
    }

    @Override
    public void displaySalary() {
        System.out.println("Salary Details:");
        System.out.println("Basic Pay: " + (int) basicPay);
        System.out.println("HRA: " + (int) hra);
        System.out.println("T.A: " + (int) ta);
        System.out.println("Total Amount: " + (int) calculateSalary());
    }
}

// Contract Employee class
class ContractEmployee implements EmployeeSalary {

    private String employeeId;
    private double basicPay;
    private double hra;
    private double ta;

    // Constructor
    ContractEmployee(String employeeId) {
        this.employeeId = employeeId;
        this.basicPay = 12000;
        this.hra = 0;
        this.ta = 3000;
    }

    @Override
    public String getEmployeeId() {
        return employeeId;
    }

    @Override
    public double calculateSalary() {
        return basicPay + hra + ta;
    }

    @Override
    public void displaySalary() {
        System.out.println("Salary Details:");
        System.out.println("Basic Pay: " + (int) basicPay);
        System.out.println("HRA: " + (int) hra);
        System.out.println("T.A: " + (int) ta);
        System.out.println("Total Amount: " + (int) calculateSalary());
    }
}

// Main class
public class EmployeePayroll {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee Id: ");
        String employeeId = sc.nextLine();

        // Interface reference
        EmployeeSalary employee;

        // Create appropriate employee object
        if (employeeId.toUpperCase().startsWith("R")) {
            employee = new RegularEmployee(employeeId);
        } else if (employeeId.toUpperCase().startsWith("C")) {
            employee = new ContractEmployee(employeeId);
        } else {
            System.out.println("Invalid Employee Id");
            sc.close();
            return;
        }

        // Access implementation through interface reference
        employee.displaySalary();

        sc.close();
    }
}
