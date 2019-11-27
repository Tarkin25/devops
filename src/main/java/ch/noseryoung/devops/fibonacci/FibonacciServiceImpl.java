package ch.noseryoung.devops.fibonacci;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class FibonacciServiceImpl implements FibonacciService {

    @Override
    public List<BigInteger> getFibonacciNumbersLimit(BigInteger limit) {
        List<BigInteger> fibonacciNumbers = new LinkedList<>();

        BigInteger lastFib = BigInteger.ZERO, fib = BigInteger.ONE;
        BigInteger temp;

        while(fib.compareTo(limit) <= 0) {
            fibonacciNumbers.add(fib);

            temp = fib;

            fib = fib.add(lastFib);

            lastFib = temp;
        }

        return fibonacciNumbers;
    }

    @Override
    public List<BigInteger> getFibonacciNumbersIterations(Integer iterations) {
        List<BigInteger> fibonacciNumbers = new ArrayList<>(iterations);

        BigInteger lastFib = BigInteger.ZERO, fib = BigInteger.ONE;
        BigInteger temp;

        for(int i=0;i<iterations;i++) {
            fibonacciNumbers.add(fib);

            temp = fib;

            fib = fib.add(lastFib);

            lastFib = temp;
        }

        return fibonacciNumbers;
    }
}
