package algorithms;


import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.util.Collections.unmodifiableList;

public class QRoundCalculator {
    private int qNumber;
    private List<Pair> pairs = new ArrayList<>();

    private QRoundCalculator(int qNumber) {
        this.qNumber = qNumber;
    }

    public static List<Pair> findAllPairs(int qNumber) {
        QRoundCalculator calculator = new QRoundCalculator(qNumber);
        calculator.calculate();
        return calculator.getResult();
    }

    private List<Pair> getResult() {
        return unmodifiableList(pairs);
    }

    private void calculate() {
        double limitation = Math.sqrt(qNumber);
        for (int n = 0; n <= limitation; n++) {
            for (int m = 0; m <= n; m++) {
                if (isQRoundPair(n, m)) {
                    addPairsFor(n, m);
                    if (n != m) {
                        addPairsFor(m, n);
                    }
                }
            }
        }
    }

    private void addPairsFor(int n, int m) {
        if (n == 0) {
            if (m == 0) {
                pairs.add(new Pair(n, m));
            } else {
                pairs.add(new Pair(n, m));
                pairs.add(new Pair(n, -m));
            }
        } else {
            if (m == 0) {
                pairs.add(new Pair(n, m));
                pairs.add(new Pair(-n, m));
            } else {
                pairs.add(new Pair(n, m));
                pairs.add(new Pair(-n, m));
                pairs.add(new Pair(n, -m));
                pairs.add(new Pair(-n, -m));
            }
        }
    }

    private boolean isQRoundPair(int n, int m) {
        return n * n + m * m == qNumber;
    }

    public static class Pair {
        int n, m;

        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }

        @Override
        public String toString() {
            return format("(%d, %d)", n, m);
        }
    }
}
