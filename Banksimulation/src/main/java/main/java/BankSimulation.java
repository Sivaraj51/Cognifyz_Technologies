package main.java;

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0);

        Thread customer1 = new Thread(new main.java.Customer(account, true, 250.0), "Customer1");
        Thread customer2 = new Thread(new main.java.Customer(account, false, 167.0), "Customer2");
        Thread customer3 = new Thread(new main.java.Customer(account, true, 376.0), "Customer3");
        Thread customer4 = new Thread(new main.java.Customer(account, false, 123.0), "Customer4");

        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();

        try {
            customer1.join();
            customer2.join();
            customer3.join();
            customer4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
