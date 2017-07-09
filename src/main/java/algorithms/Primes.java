package algorithms;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

public class Primes {

    public static List<Integer> findBetween(int startInclusive, int endInclusive) {
        Sieve sieve = new Sieve(endInclusive);

        return range(startInclusive, endInclusive)
                .filter(sieve::isPrime)
                .mapToObj(Integer::valueOf)
                .collect(toList());
    }

    public static int countBetween(int startInclusive, int endInclusive) {
        List<Integer> primes = findBetween(startInclusive, endInclusive);
        return primes.size();
    }

    static class Sieve {
        private static final boolean NOT_PRIME = true;
        boolean[] sieve;
        boolean needsRecalculating = true;

        Sieve(int sizeInclusive) {
            sieve = new boolean[sizeInclusive + 1];
            sieve[0] = NOT_PRIME;
            sieve[1] = NOT_PRIME;
        }

        boolean isPrime(int number) {
            if (needsRecalculating) {
                needsRecalculating = false;
                calculate();
            }
            return !this.sieve[number];
        }

        private void calculate() {
            for (int i = 2; i < sieve.length; i++) {
                if (!this.sieve[i]) {
                    for (int j = 2 * i; j < sieve.length; j += i) {
                        sieve[j] = NOT_PRIME;
                    }
                }
            }
        }
    }
}
