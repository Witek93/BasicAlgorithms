import algorithms.Primes;
import algorithms.QRoundCalculator;
import utils.TimeTracker;

import static algorithms.DistanceBetweenElements.findMinimumDistanceBetweenElements;
import static java.lang.String.format;
import static utils.TimeTracker.timeTracker;

public class Main {
    public static void main(String[] args) {
        print(timeTracker(() -> Primes.findBetween(2, 50000)));
        print(timeTracker(() -> Primes.countBetween(2, 50000000)));
        print(timeTracker(() -> QRoundCalculator.findAllPairs(1000000)));
        print(timeTracker(() -> findMinimumDistanceBetweenElements(new int[]{2, 400, 200, 600})));
    }

    private static <T> void print(TimeTracker<T> tracker) {
        System.out.println(format("Time=[%s] and the result=[%s]",
                tracker.getResult(),
                tracker.getResultOfMeasuredFunction().toString()));
    }
}
