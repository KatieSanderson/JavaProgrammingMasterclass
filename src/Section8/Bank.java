package Section8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Bank {

    private final List<Branch> branches;

    Bank() {
        branches = new ArrayList<>();
    }

    void addBranch(String branchName) {
        if (branches.stream().map(Branch::getBranchName).anyMatch(branchName::equals)) {
            System.out.println("Branch name already exists");
        } else {
            branches.add(new Branch(branchName));
        }
    }

    void addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch current = null;
        Predicate<Branch> stringPredicate = branch -> branch.getBranchName().equals(branchName);
        for (Branch branch : branches) {
            if (stringPredicate.test(branch)) {
                current = branch;
            }
        }
        if (current == null) {
            System.out.println("Branch not in this Bank");
        } else {
            current.addCustomer(customerName, initialTransaction);
        }
    }

    void addTransaction(String branchName, String customerName, double newTransaction) {
        Branch current = null;
        for (Branch branch : branches) {
            if (branch.getBranchName().equals(branchName)) {
                current = branch;
            }
        }
        if (current == null) {
            System.out.println("Branch not in this Bank");
        } else {
            current.addTransaction(customerName, newTransaction);
        }
    }

    void listCustomersOfBranch(String branchName, boolean includeTransactions) {
        Branch current = null;
        Predicate<Branch> stringPredicate = branch -> branch.getBranchName().equals(branchName);
        for (Branch branch : branches) {
            if (stringPredicate.test(branch)) {
                current = branch;
            }
        }
        if (current == null) {
            System.out.println("Branch not in this Bank");
        } else {
            current.listCustomersOfBranch(includeTransactions);
        }
    }
}
