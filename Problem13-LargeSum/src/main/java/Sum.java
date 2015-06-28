import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by michelesartini on 28/06/2015.
 */
public class Sum implements Callable<BigInteger> {

    private final List<BigInteger> toAdd;

    public Sum(String[] values) {
        toAdd = new ArrayList<BigInteger>(values.length);
        for (String value : values) {
            toAdd.add(new BigInteger(value));
        }
    }

    public Sum(BigInteger[] values) {
        toAdd = Arrays.asList(values);
    }

    public BigInteger call() throws Exception {
        BigInteger total = BigInteger.ZERO;
        for (BigInteger add : toAdd) {
            total = total.add(add);
        }
        return total;
    }
}
