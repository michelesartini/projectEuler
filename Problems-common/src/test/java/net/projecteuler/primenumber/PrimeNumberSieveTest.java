package net.projecteuler.primenumber;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Created by michelesartini on 20/06/2015.
 */
public class PrimeNumberSieveTest {

    @Test(expected = IllegalArgumentException.class)
    public void calculatePrimes3() {
        PrimeNumberSieve.atkinSieve(3);
    }

    @Test
    public void calculatePrimes4() {
        Integer[] exp = new Integer[] {2, 3};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> generated = PrimeNumberSieve.atkinSieve(4);
        assertEquals(expected, generated);
    }

    @Test
    public void calculatePrimes20() {
        Integer[] exp = new Integer[] {2, 3, 5, 7, 11, 13, 17, 19};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> generated = PrimeNumberSieve.atkinSieve(20);
        assertEquals(expected, generated);
    }

    @Test
    public void calculatePrimes40() {
        Integer[] exp = new Integer[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> generated = PrimeNumberSieve.atkinSieve(40);
        assertEquals(expected, generated);
    }

}
