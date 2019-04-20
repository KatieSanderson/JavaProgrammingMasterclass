package Section18;

import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class BankAccountTest {

    private BankAccount bankAccount;
    private static int count;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before test cases. Count = " + count++);
    }

    @Before
    public void setup() {
        bankAccount = new BankAccount("Katie", "Sanderson", 1000.00, BankAccount.CHECKING);
        System.out.println("Setting up test");
    }


    @Test
    public void deposit() {
        double balance = bankAccount.deposit(200, true);
        assertEquals(balance, 1200, 0);
    }

    @Test
    public void withdraw_branch() {
        double balance = bankAccount.withdraw(600, true);
        assertEquals(balance, 400, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() {
        bankAccount.withdraw(600, false);
    }

    @Test
    public void getBalance_deposit() {
        bankAccount.deposit(200, true);
        assertEquals(bankAccount.getBalance(), 1200, 0);
    }

    @Test
    public void getBalance_withdraw() {
        bankAccount.withdraw(200, true);
        assertEquals(bankAccount.getBalance(), 800, 0);
    }

    @Test
    public void isChecking_true() {
        assertTrue(bankAccount.isChecking());
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("This executes after test cases. Count = " + count++);
    }

    @After
    public void tearDown() {
        System.out.println("Count = " + count++);
    }
}