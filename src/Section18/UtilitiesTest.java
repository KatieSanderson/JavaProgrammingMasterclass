package Section18;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertArrayEquals;


public class UtilitiesTest {

    Utilities util;

    @Before
    public void setup() {
        util = new Utilities();
    }

    @Test
    public void everyNthChar() {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        char[] exp = {'e', 'l'};
        assertArrayEquals(exp, util.everyNthChar(arr, 2));
    }

    @Test
    public void everyNthChar_largeN() {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        char[] exp = {'h', 'e', 'l', 'l', 'o'};
        assertArrayEquals(exp, util.everyNthChar(arr, 6));
    }

    @Test
    public void removePairs_oddPairs() {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
    }

    @Test
    public void removePairs_noPairs() {
        assertEquals("ABCDEF", util.removePairs("ABCDEF"));
    }

    @Test
    public void removePairs_null() {
        assertNull(util.removePairs(null));
    }

    @Test
    public void removePairs_threeOfAKind() {
        assertEquals("A", util.removePairs("AAA"));
    }

    @Test
    public void removePairs_evenPairs() {
        assertEquals("ABCDEF", util.removePairs("ABBCCDEEF"));
    }

    @Test
    public void converter_10and5() {
        assertEquals(300, util.converter(10, 5));
    }

    @Test (expected = ArithmeticException.class)
    public void converter_divideByZero() {
        util.converter(10, 0);
    }

    @Test
    public void nullIfOddLength_odd() {
        assertNull(util.nullIfOddLength("ABC"));
    }

    @Test
    public void nullIfOddLength_even() {
        assertNotNull(util.nullIfOddLength("ABCD"));
    }
}