package net.projecteuler;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by michelesartini on 15/06/2015.
 */
public class TriangularNumberTest {

    @Test
    public void isTriangularNumber10() {
        assertTrue(TriangularNumber.isTriangularNumber(10));
    }

    @Test
    public void isTriangularNumber0() {
        assertTrue(TriangularNumber.isTriangularNumber(0));
    }

    @Test
    public void isTriangularNumber91() {
        assertTrue(TriangularNumber.isTriangularNumber(91));
    }

    @Test
    public void isNotTriangularNumber9() {
        assertFalse(TriangularNumber.isTriangularNumber(9));
    }

    @Test
    public void isNotTriangularNumberLessThan0() {
        assertFalse(TriangularNumber.isTriangularNumber(-9));
    }
}
