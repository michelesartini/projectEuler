package net.projecteuler;

/**
 * The triangle numbers are given by the following explicit formulas:
 * Tn = n ( n + 1 ) / 2
 *
 * Tn can also be expressed as binomial coefficient (n + 1)
 *                                                  (  2  )
 *
 * (n + 1) = (n + 1)! / 2! (n + 1 - 2)!
 * (  2  )
 *
 * Created by michelesartini on 15/06/2015.
 */
public class TriangularNumber {

    /**
     * to see if a number x is triangular, let
     * x = n(n+1)/2.
     *
     * Solving for x, we obtain
     * n^2 + n - 2x = 0
     * or
     * n = (Sqrt[1+8x] - 1)/2.
     *
     * An integer x is triangular if and only if 8x + 1 is a square
     *
     * @param x
     * @return
     */
    public static boolean isTriangularNumber(int x) {
        if (x < 0) {
            return false;
        }

        long calcNum = 8 * x + 1;
        long sqrt = (long) Math.sqrt(calcNum);
        sqrt = sqrt * sqrt;
        return sqrt == calcNum ? true : false;
    }
}
