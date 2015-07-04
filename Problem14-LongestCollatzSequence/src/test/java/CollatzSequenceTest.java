import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * Created by michelesartini on 28/06/2015.
 */
public class CollatzSequenceTest {

    /**
     * Testing:
     * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
     *
     */
    @Test
        public void nextSequece() {

        CollatzSequence collatzSequence = new CollatzSequence();

        BigInteger value = new BigInteger("13");
        BigInteger generated = collatzSequence.nextSequence(value);
        BigInteger expected = new BigInteger("40");
        assertEquals(expected, generated);

        value = new BigInteger("40");
        generated = collatzSequence.nextSequence(value);
        expected = new BigInteger("20");
        assertEquals(expected, generated);

        value = new BigInteger("20");
        generated = collatzSequence.nextSequence(value);
        expected = new BigInteger("10");
        assertEquals(expected, generated);

        value = new BigInteger("10");
        generated = collatzSequence.nextSequence(value);
        expected = new BigInteger("5");
        assertEquals(expected, generated);

        value = new BigInteger("5");
        generated = collatzSequence.nextSequence(value);
        expected = new BigInteger("16");
        assertEquals(expected, generated);

        value = new BigInteger("16");
        generated = collatzSequence.nextSequence(value);
        expected = new BigInteger("8");
        assertEquals(expected, generated);

        value = new BigInteger("8");
        generated = collatzSequence.nextSequence(value);
        expected = new BigInteger("4");
        assertEquals(expected, generated);

        value = new BigInteger("4");
        generated = collatzSequence.nextSequence(value);
        expected = new BigInteger("2");
        assertEquals(expected, generated);

        value = new BigInteger("2");
        generated = collatzSequence.nextSequence(value);
        expected = new BigInteger("1");
        assertEquals(expected, generated);
    }

    @Test
    public void generateSequence13() {
        CollatzSequence collatzSequence = new CollatzSequence();
        List<BigInteger> generated = collatzSequence.generateSequence(new BigInteger("13"));
        List<BigInteger> expected = Arrays.asList(  new BigInteger("13"),
                new BigInteger("40"),
                new BigInteger("20"),
                new BigInteger("10"),
                new BigInteger("5"),
                new BigInteger("16"),
                new BigInteger("8"),
                new BigInteger("4"),
                new BigInteger("2"),
                new BigInteger("1"));
        assertEquals(expected, generated);
    }

    @Test
    public void generateSequenceSize() {
        CollatzSequence collatzSequence = new CollatzSequence();
        int generated = collatzSequence.generateSequenceSize(new BigInteger("13"));
        assertEquals(10, generated);

        generated = collatzSequence.generateSequenceSize(new BigInteger("50"));
        assertEquals(26, generated);
    }
}
