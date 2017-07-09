package utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class TimeTracker<T> {
    private LocalDateTime start;
    private LocalDateTime end;
    private T result;
    private Supplier<T> supplier;

    private TimeTracker(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public static <T> TimeTracker<T> timeTracker(Supplier<T> supplier) {
        return new TimeTracker<>(supplier);
    }

    public Duration getResult() {
        if (start == null || end == null) {
            measure();
        }
        return Duration.between(start, end);
    }

    public T getResultOfMeasuredFunction() {
        return result;
    }

    private TimeTracker<T> measure() {
        start = LocalDateTime.now();
        result = supplier.get();
        end = LocalDateTime.now();
        return this;
    }
}
