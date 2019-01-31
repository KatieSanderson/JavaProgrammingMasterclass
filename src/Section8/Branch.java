package Section8;

import java.util.ArrayList;
import java.util.List;

class Branch {

    private final List<Customer> customers;
    private final String branchName;

    Branch(String branchName) {
        this.customers = new ArrayList<>();
        this.branchName = branchName;
    }

    void addCustomer(String customerName, double initialTransaction) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(customerName)) {
                System.out.println("Customer already exists");
                return;
            }
        }
        customers.add(new Customer(customerName, initialTransaction));
    }

    void addTransaction(String customerName, double transaction) {
        Customer current = null;
        for (Customer customer : customers) {
            if (customer.getCustomerName().equals(customerName)) {
                current = customer;
            }
        }
        if (current == null) {
            System.out.println("Customer not in this branch");
        } else {
            current.addTransaction(transaction);
        }
    }

    private List<Customer> getCustomers() {
        return customers;
    }

    String getBranchName() {
        return branchName;
    }

    void listCustomersOfBranch(boolean includeTransactions) {
        for (Customer customer : getCustomers()) {
            if (includeTransactions) {
                System.out.println(customer.getCustomerName() + " transactions are:");
                for (Double transaction : customer.getTransactions()) {
                    System.out.println("Transaction: " + transaction);
                }
            } else {
                System.out.println("Customer name: " + customer.getCustomerName());
            }
        }
    }
}
