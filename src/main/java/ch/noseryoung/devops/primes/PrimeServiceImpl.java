package ch.noseryoung.devops.primes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Service
public class PrimeServiceImpl implements PrimeService {

    @Override
    public Boolean isPrimeNumber(Long number) {
        if(number < 2) return false;

        return LongStream.rangeClosed(2L, (long)Math.sqrt(number)).noneMatch(l -> number % l == 0);
    }

    @Override
    public List<Long> getPrimes(Long maxInclusive) {
        return getPrimes(2L, maxInclusive);
    }

    @Override
    public List<Long> getPrimes(Long minInclusive, Long maxInclusive) {
        return LongStream.rangeClosed(minInclusive, maxInclusive).filter(l -> isPrimeNumber(l)).boxed().collect(Collectors.toList());
    }
}
