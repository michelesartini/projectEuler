package net.projecteuler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by michelesartini on 20/06/2015.
 */
public class NumberDivisorsTest {

    @Test
    public void numberDivisors28() {
        Integer[] exp = new Integer[] {1, 2, 4, 7, 14, 28};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> generated = NumberDivisors.numberDivisorsImproved(28);
        Collections.sort(generated);
        assertEquals(expected, generated);
        generated = NumberDivisors.numberDivisors(28);
        Collections.sort(generated);
        assertEquals(expected, generated);
    }

    @Test
     public void numberDivisors20() {
        Integer[] exp = new Integer[] {1, 2, 4, 5, 10, 20};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> generated = NumberDivisors.numberDivisorsImproved(20);
        Collections.sort(generated);
        assertEquals(expected, generated);
        generated = NumberDivisors.numberDivisors(20);
        Collections.sort(generated);
        assertEquals(expected, generated);
    }

    @Test
         public void numberDivisors1() {
        Integer[] exp = new Integer[] {1};
        List<Integer> expected = Arrays.asList(exp);
        List<Integer> generated = NumberDivisors.numberDivisorsImproved(1);
        Collections.sort(generated);
        assertEquals(expected, generated);
        generated = NumberDivisors.numberDivisors(1);
        Collections.sort(generated);
        assertEquals(expected, generated);
    }

    @Test
    public void numberDivisors0() {
        List<Integer> generated = NumberDivisors.numberDivisorsImproved(0);
        Collections.sort(generated);
        assertTrue(generated.isEmpty());
        generated = NumberDivisors.numberDivisors(0);
        Collections.sort(generated);
        assertTrue(generated.isEmpty());
    }
}
