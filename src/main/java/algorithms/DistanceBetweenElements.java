package algorithms;

import static java.util.Arrays.copyOf;
import static java.util.Arrays.sort;

public class DistanceBetweenElements {
    public static int findMinimumDistanceBetweenElements(int[] originalArray) {
        if (isDistanceCalculable(originalArray)) {
            int[] array = copyOf(originalArray, originalArray.length);
            sort(array);
            return findMinimumDistanceOnSortedArray(array);
        }
        return Integer.MAX_VALUE;
    }

    private static int findMinimumDistanceOnSortedArray(int[] sortedArray) {
        int minimumDistance = Integer.MAX_VALUE;

        for (int i = 0; i < sortedArray.length - 1; i++) {
            int distance = Math.abs(sortedArray[i] - sortedArray[i + 1]);
            if (distance < minimumDistance) {
                minimumDistance = distance;
            }
        }

        return minimumDistance;
    }

    private static boolean isDistanceCalculable(int[] array) {
        return array != null && array.length > 1;
    }
}
