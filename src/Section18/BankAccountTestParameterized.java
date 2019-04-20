package Section18;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParameterized {

    private BankAccount bankAccount;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Test
    public void setup() {
        bankAccount = new BankAccount("Katie", "Sanderson", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {100, true, 1100},
                {200, true, 1200},
                {325.14, true, 1325.14},
                {489, true, 1489},
                {1000, true, 1000}
        });
    }

    @Test
    public void deposit() {
        bankAccount.deposit(amount, branch);
        assertEquals(expected, bankAccount.getBalance(), 0.01);
    }
}
