package Section18;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class UtilitiesTestParameterized {

    private Utilities util;
    private String input;
    private String expected;

    public UtilitiesTestParameterized(String input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setup() {
        util = new Utilities();
    }

    @Test
    public void removePairs() {
        assertEquals(expected, util.removePairs(input));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"1122334455", "12345"},
                {"ZYZQQB", "ZYZQB"},
                {"A", "A"}
        });
    }
}
