import java.util.Scanner;

// Final class prevents inheritance
final class Customer {

    private String name;
    private String customerId;

    // Constructor
    Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    void displayCustomer() {
        System.out.println("Customer Name      : " + name);
        System.out.println("Customer ID        : " + customerId);
    }
}

// Account class stores basic account information
class Account {

    private String accountNo;
    private double balance;

    // Constructor
    Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    void displayAccount() {
        System.out.println("Account Number     : " + accountNo);
        System.out.println("Account Balance    : " + balance);
    }
}

// RBI is the base class
class RBI {

    // Final value cannot be changed by derived classes
    protected final double MIN_INTEREST_RATE = 4.0;

    // Constructor
    RBI() {
    }

    // Method to be overridden by derived classes
    double getInterestRate() {
        return MIN_INTEREST_RATE;
    }

    void displayRules() {
        System.out.println("Minimum RBI Interest Rate : " + MIN_INTEREST_RATE + "%");
    }
}

// SBI inherits RBI
class SBI extends RBI {

    // Constructor uses super()
    SBI() {
        super();
    }

    // Method overriding
    @Override
    double getInterestRate() {
        return super.MIN_INTEREST_RATE + 3.0;
    }
}

// ICICI inherits RBI
class ICICI extends RBI {

    // Constructor uses super()
    ICICI() {
        super();
    }

    // Method overriding
    @Override
    double getInterestRate() {
        return super.MIN_INTEREST_RATE + 2.5;
    }
}

// PNB inherits RBI
class PNB extends RBI {

    // Constructor uses super()
    PNB() {
        super();
    }

    // Method overriding
    @Override
    double getInterestRate() {
        return super.MIN_INTEREST_RATE + 2.0;
    }
}

// Main class
public class BankPolymorphism {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Customer and Account objects
        Customer customer = new Customer("Rahul", "C101");
        Account account = new Account("A1001", 50000);

        // RBI reference for dynamic polymorphism
        RBI bank;

        System.out.print("Enter the Bank name to find the rate of Interest : ");
        String bankName = sc.nextLine();

        // Assign different bank objects to RBI reference
        if (bankName.equalsIgnoreCase("RBI")) {
            bank = new RBI();
        } else if (bankName.equalsIgnoreCase("SBI")) {
            bank = new SBI();
        } else if (bankName.equalsIgnoreCase("ICICI")) {
            bank = new ICICI();
        } else if (bankName.equalsIgnoreCase("PNB")) {
            bank = new PNB();
        } else {
            System.out.println("Invalid Bank Name");
            sc.close();
            return;
        }

        System.out.println(bankName.toUpperCase() +
                " rate of interest is : " +
                bank.getInterestRate() + "%");

        sc.close();
    }
}
