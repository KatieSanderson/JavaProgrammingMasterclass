package Section8;

import java.util.ArrayList;
import java.util.List;

class Customer {

    private final List<Double> transactions;
    private final String customerName;

    Customer(String name, double initialTransaction) {
        this.transactions = new ArrayList<>();
        transactions.add(initialTransaction);
        this.customerName = name;
    }

    void addTransaction(double transaction) {
        transactions.add(transaction);
    }

    List<Double> getTransactions() {
        return transactions;
    }

    String getCustomerName() {
        return customerName;
    }

}
