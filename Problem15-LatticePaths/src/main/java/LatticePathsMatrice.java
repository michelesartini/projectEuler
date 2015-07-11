/**
 * Problem 15
 *
 * Lattice paths
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 *
 * Created by michelesartini on 04/07/2015.
 */
public class LatticePathsMatrice {

    private static final int SIZE = 20;

    private static final long[][] GRID = new long[SIZE+1][SIZE+1];

    /**
     * If we consider a grid 2x2:
     *
     * In the position (1,1) we will have 2 because we can only go or right or down therefore only one movement,
     * so in total 2.
     *
     * In the position (1,0) we will have 3 because if we go down we will have 1
     * (from this new position we can only go right).
     * if we go right we will have 2 from the previous computation, so 1 + 2.
     * Same applies for (0,1)
     *
     * In the position (0,0) we can go or right or down we will have 3 in both cases therefore 3 + 3.
     *
     * @param grid
     * @param size
     */
    private static void generateGrid(long[][] grid, int size) {

        for (int i = 0; i < size; i++) {
            grid[i][size] = 1;
            grid[size][i] = 1;
        }

        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                grid[i][j] = grid[i+1][j] + grid[i][j+1];
            }
        }
    }

    private static void printGrid(long[][] grid, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(String.format("%-11d \t", grid[i][j]));
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        generateGrid(GRID, SIZE);
        printGrid(GRID, SIZE);
        System.out.println(String.format("Number of paths: %d", GRID[0][0]));
    }
}
