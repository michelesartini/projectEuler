import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem 14
 *
 * Longest Collatz sequence
 *
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * Created by michelesartini on 28/06/2015.
 */
public class MainNaive {

    private static final BigInteger LIMIT = new BigInteger("1000000");

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        CollatzSequence collatzSequence = new CollatzSequence();

        BigInteger numberSeq = new BigInteger("13");
        int sequenceSize = 0;

        for (BigInteger i = numberSeq; i.compareTo(LIMIT) < 0; i = i.add(BigInteger.ONE)) {
            System.out.println("----------------------------");
            System.out.println(String.format("Processing %d", i));
            int genSeqSize = collatzSequence.generateSequenceSize(new BigInteger(String.valueOf(i)));
            System.out.println(String.format("Sequence size %d", genSeqSize));
            if (sequenceSize < genSeqSize) {
                sequenceSize = genSeqSize;
                numberSeq = i;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("----------------------------");
        System.out.println(String.format("Result, number %d, size %d", numberSeq, sequenceSize));

        end = end - start;
        System.out.println("Execution time: " + end + "(ms)");

    }
}
