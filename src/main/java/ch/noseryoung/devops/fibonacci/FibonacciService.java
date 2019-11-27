package ch.noseryoung.devops.fibonacci;

import java.math.BigInteger;
import java.util.List;

public interface FibonacciService {

    List<BigInteger> getFibonacciNumbersLimit(BigInteger limit);

    List<BigInteger> getFibonacciNumbersIterations(Integer iterations);

}
