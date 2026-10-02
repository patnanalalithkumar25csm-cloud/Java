class Customer {
    String name, location;

    Customer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    void order(Order o) {
        System.out.println(name + " placed " + o.number);
    }
}

class Order {
    String date, number;

    Order(String number) {
        this.number = number;
        date = "17-09-2026";
    }

    Order(String number, String date) {
        this.number = number;
        this.date = date;
    }

    void confirm() {
        System.out.println(number + " Confirmed");
    }

    void confirm(String type) {
        System.out.println(type + " Order Confirmed");
    }

    void close() {
        System.out.println(number + " Closed");
    }
}

class SpecialOrder extends Order {
    SpecialOrder(String n, String d) {
        super(n, d);
    }

    void dispatch() {
        System.out.println("Special Order Dispatched");
    }
}

class NormalOrder extends Order {
    NormalOrder(String n, String d) {
        super(n, d);
    }

    void dispatch() {
        System.out.println("Normal Order Dispatched");
    }

    void receive() {
        System.out.println("Normal Order Received");
    }
}

public class OrderManagement {
    public static void main(String[] args) {

        Customer c = new Customer("Ravi", "Vizag");

        SpecialOrder s = new SpecialOrder("S101", "17-09-2026");
        c.order(s);
        s.confirm("Special");
        s.dispatch();
        s.close();

        NormalOrder n = new NormalOrder("N101", "17-09-2026");
        c.order(n);
        n.confirm();
        n.dispatch();
        n.receive();
        n.close();
    }
}
