package net.projecteuler;

/**
 * Problem 15
 *
 * Lattice paths
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 * Created by michelesartini on 11/07/2015.
 */
public class LatticePathsBinomialCoefficient {

    private static final int SIZE = 20;

    public static void main(String args[]) {
        long paths = discoverPaths(SIZE);
        System.out.println(String.format("Number of paths: %d", paths));
    }

    /**
     * In a N×N grid where N = 2, all paths are 1) DDRR 2) DRDR 3) DRRD 4) RDRD 5) RDDR 6) RRDD.
     * So the number of paths is given by the Binomial Coefficient between 2N and N.
     * I wrote 2N because as you can see in the paths above, we always have a couple of N values, i.e. DDRR
     *
     * The Binomial Coefficient can be calculated using the multiplicative formula see wikipedia for details.
     *
     * @link https://en.wikipedia.org/wiki/Binomial_coefficient#Multiplicative_formula
     *
     * @param gridSize
     * @return
     */
    private static long discoverPaths(int gridSize) {
        long paths = 1;
        for (int i = 0; i < gridSize; i++) {
            paths *= (2 * gridSize) - i;
            paths /= i + 1;
        }
        return paths;
    }
}
