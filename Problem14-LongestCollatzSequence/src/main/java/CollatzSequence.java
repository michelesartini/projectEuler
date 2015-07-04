import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Created by michelesartini on 28/06/2015.
 */
public class CollatzSequence {

    private static final BigInteger MUL = new BigInteger("3");
    private static final BigInteger DIV = new BigInteger("2");

    private Map<BigInteger, Integer> generatedSequence = new HashMap<BigInteger, Integer>();

    public List<BigInteger> generateSequence(BigInteger start) {
        final List<BigInteger> sequence = new ArrayList<BigInteger>();
        for (; !start.equals(BigInteger.ONE); start = nextSequence(start)) {
            sequence.add(start);
        }
        sequence.add(BigInteger.ONE);
        return sequence;
    }

    public int generateSequenceSize(BigInteger start) {
        BigInteger toProcess = start;
        int sequence = 1;
        for (; !toProcess.equals(BigInteger.ONE); toProcess = nextSequence(toProcess)) {
            if (generatedSequence.containsKey(toProcess)) {
                sequence += generatedSequence.get(toProcess);
                break;
            } else {
                sequence++;
            }
        }

        generatedSequence.putIfAbsent(start, sequence);

        return sequence;
    }

    public BigInteger nextSequence(BigInteger value) {

        return value.mod(DIV).equals(BigInteger.ZERO) ?
                    // n → n/2 (n is even)
                    value.divide(DIV) :
                    // n → 3n + 1 (n is odd)
                    value.multiply(MUL).add(BigInteger.ONE);
    }
}
