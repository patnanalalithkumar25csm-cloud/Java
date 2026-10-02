class Account{
    int accnum;
    double balance;
    String acctype;
    public Account(int n,double m,String l){
        this.accnum=n;
        this.balance=m;
        this.acctype=l;
    }
    void details() {
        System.out.println("accnum :"+accnum);
        System.out.println("balance :"+balance);
        System.out.println("acctype :"+acctype);
    }
    void deposit(double amount) {

        balance = balance + amount;
        System.out.println("Deposited: " + amount);

    }
    void withdraw(double amount){
        if (amount<=balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    void transfer(Account receiver,double amount) {
        if(amount > 0 && amount <= balance) {
            this.balance = this.balance - amount;
            receiver.balance = receiver.balance + amount;
            System.out.println("Transferred: " + amount);
            System.out.println("To Account: " + receiver.accnum);
        }else {
            System.out.println("Transfer failed");
        }
    }
}
class SavingsAccount extends Account{
    double interstrate;
    public SavingsAccount(int n,double m,double k){
        super(n,m,"saving account");
        this.interstrate=k;
    }
    void calculateintrest() {
        double intrest = balance * (interstrate / 100);
        balance = balance + intrest;
        System.out.println("value :"+intrest);
    }
    void account() {
        System.out.println("accnum :"+accnum);
        System.out.println("balance :"+balance);
        System.out.println("interstrate :"+interstrate);
    }
}
class CurrentAccount extends Account{
    double overdraftlimit;
    public CurrentAccount(int n,double m,double o){
        super(n,m,"current account");
        this.overdraftlimit=o;
    }
    @Override
    void withdraw(double amount){
        if (amount > 0 && amount <= balance+overdraftlimit) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("exceed overdraft limt");
        }
    }
    void account() {
        System.out.println("accnum :"+accnum);
        System.out.println("balance :"+balance);
        System.out.println("overdraftlimit :"+overdraftlimit);
    }
}
public class Bank {
    public static void main(String []args) {
        SavingsAccount s = new SavingsAccount(3000,2424,50);
        CurrentAccount c = new CurrentAccount(2254,5845,300);
        System.out.println("savings account");
        s.account();
        System.out.println("\ncurrent account");
        c.account();
        System.out.println("\nDeposit");
        s.deposit(1000);
        System.out.println("\nwithdraw");
        c.withdraw(2000);
        System.out.println("\ninterstrate");
        s.calculateintrest();
        System.out.println("\ntransfer");
        s.transfer(c,500);
        System.out.println("\nwithdraw");
        c.withdraw(5000);
        System.out.println("\nfinal account details\n");
        s.account();
        c.account();
    }
}
