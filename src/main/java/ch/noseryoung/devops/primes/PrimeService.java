package ch.noseryoung.devops.primes;

import java.util.List;

public interface PrimeService {

    Boolean isPrimeNumber(Long number);

    List<Long> getPrimes(Long maxInclusive);

    List<Long> getPrimes(Long minInclusive, Long maxInclusive);

}
